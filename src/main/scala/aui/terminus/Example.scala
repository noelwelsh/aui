package aui.terminus

@main def example(): Unit = {
  import aui.*
  import aui.terminus.given
  import aui.syntax.all.*
  val ui = Component.textField("What Can You See Right Now?")
  val result = ui.create()
  println(s"Result is $result")
}
