package aui.algebra

type Validation[A] = A => Either[String, A]
object Validation {
  def succeed[A](value: A): Either[String, A] = Right(value)
}
