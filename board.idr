module Board

import Data.Vect

data Space = Empty | X | O

||| Type Board k n is a k-dimensional board with length n in all dimensions
data Board : Nat -> Nat -> Type where
     Point : Space -> Board Z n
     Row  : Vect n (Board k n) -> Board (S k) n

newBoard : (k : Nat) -> (n : Nat) -> Board k n
newBoard Z n = Point Empty
newBoard (S k) n = Row $ replicate n (newBoard k n)

Line : Nat -> Type
Line = Board 1

index : Vect k (Fin n) -> Board k n -> Space
index _       (Point s) = s
index (i::is) (Row xs)  = index is (index i xs)

||| Returns the ((2^k) choose 2) length n lines through the given board.  
||| This is the set of lines on which a player could win.
lines : Board k n -> List (Line n)
