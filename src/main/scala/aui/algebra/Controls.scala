package aui.algebra

trait Controls extends Algebra {
  def textField(label: String, placeholder: String, validation: Validation[String]): Ui[String]

  def choice[A](label: String, options: Seq[(String, A)]): Ui[A]
}
