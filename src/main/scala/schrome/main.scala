package schrome

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.document

val tickStream = EventStream.periodic(1000)

@main
def main(): Unit = {
    render( document.getElementById("app"), sueppchen(tickStream.map(_.toString)) )
}

def sueppchen(mit: Source[String]) = div(h1("SÜPPCHEN mit ", child.text <-- mit))