package aui.algebra

trait Text extends Algebra {
  def text(content: String): Ui[Unit]
}
