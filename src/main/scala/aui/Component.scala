package aui

import aui.algebra.*

type Component[Alg <: Algebra, A] = (alg: Alg) => alg.Ui[A]
extension [Alg <: Algebra, A](component: Component[Alg, A]) {
  def map[B](f: A => B): Component[Alg & Map, B] =
    alg => alg.map(component.apply(alg), f)

  def and[Alg2 <: Algebra, B](
      that: Component[Alg2, B]
  ): Component[Alg & Alg2 & Layout, (A, B)] =
    alg => alg.and(component.apply(alg), that.apply(alg))
}

/** Constructors for atomic UI elements. */
object Component {
  def text(content: String): Component[Text, Unit] =
    alg => alg.text(content)

  def textField(
      label: String,
      placeholder: String = "",
      validation: Validation[String] = Validation.succeed
  ): Component[Controls, String] =
    alg => alg.textField(label, placeholder, validation)

  def choice[A](
      label: String,
      options: Seq[(String, A)]
  ): Component[Controls, A] =
    alg => alg.choice(label, options)
}
