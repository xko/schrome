package schrome

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.document


@main
def main(): Unit = {
    renderOnDomContentLoaded( document.getElementById("app"), sueppchen("GURKEN") )
}

def sueppchen(mit: String) = div(h1(s"SÜPPCHEN mit $mit!!"))