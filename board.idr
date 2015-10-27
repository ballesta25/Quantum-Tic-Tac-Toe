module board

import Data.Vect

data Space = Empty | X | O

Row : Nat -> Type
Row n = Vect n Space

||| Type Board k n is a k-dimensional board with length n in all dimensions
data Board : Nat -> Nat -> Type where
     Point : Space -> Board Z n
     Line  : Vect n (Board k n) -> Board (S k) n

newBoard : (k : Nat) -> (n : Nat) -> Board k n
newBoard Z n = Point Empty
newBoard (S k) n = Line $ replicate n (newBoard k n)