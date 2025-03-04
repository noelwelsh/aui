package aui.algebra

trait Map extends Algebra {
  def map[A, B](ui: Ui[A], f: A => B): Ui[B]
}
