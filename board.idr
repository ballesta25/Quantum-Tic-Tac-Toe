module Board

import Data.Vect

data Space = Empty | X | O

||| Type Board k n is a k-dimensional board with length n in all dimensions
data Board : Nat -> Nat -> Type where
     Point : Space -> Board Z n
     Row  : Vect n (Board k n) -> Board (S k) n

unRow : Board (S k) n -> Vect n (Board k n) 
unRow (Row xs) = xs

newBoard : (k : Nat) -> (n : Nat) -> Board k n
newBoard Z n = Point Empty
newBoard (S k) n = Row $ replicate n (newBoard k n)

Line : Nat -> Type
Line = Board 1

index : Vect k (Fin n) -> Board k n -> Space
index _       (Point s) = s
index (i::is) (Row xs)  = index is (index i xs)

perpendicular : Board (S (S k)) n -> Board (S (S k)) n
perpendicular = Row . map Row . transpose . map unRow . unRow

diagonal :  Board (S (S k)) n -> Board (S k) n
diagonal = Row . diag . map unRow . unRow

||| Returns the ((2^k) choose 2) + k * (n-2)^(k-1) length n rows through the given board.  
||| This is the set of lines on which a player could win.
||| Includes some duplicates.
rows : Board k n -> List (Line n)
rows (Point _) = []
rows row@(Row {k=Z} _) = [row]
rows board@(Row {k=S p} xs) = concatMap rows xs ++ concatMap rows (unRow $ perpendicular board) ++ rows (diagonal board) ++ rows (diagonal . Row . reverse . unRow $ board)

Backtrack : Type
Backtrack = (List (Sigma (Nat,Nat) (uncurry Board)), Nat)

||| A Board structure 'zoomed in' to focus on a sub-part
||| d is the number of dimensions zoomed in
FocusBoard : (k : Nat) -> (n : Nat) -> (d : Fin (S k)) -> Type
FocusBoard k n d = (Board (k `minus` finToNat d) n, Vect (finToNat d) Backtrack)


Whole : Board k n -> FocusBoard k n 0
Whole b ?= (b, the (Vect 0 Backtrack) [])

lemma0 : (n: Nat) -> minus n 0 = n
lemma0 = proof
  intros
  induction n
  compute
  trivial
  intros
  compute
  trivial

Board.Whole_lemma_1 = proof
  intro
  intro
  rewrite lemma0 k
  intros
  trivial

-- Zoom : (Fin n) -> {p : LT d k} -> FocusBoard k n d -> FocusBoard k n (FS d)

