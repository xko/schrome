package schrome

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.document
import typings.chrome.chrome.tabs.{QueryInfo, Tab}
import typings.chrome.global.chrome


@main
def main(): Unit = {
    val tabsS = EventStream.fromJsPromise(chrome.tabs.query(new QueryInfo {}))
    render( document.getElementById("app"), tabList(tabsS.map(_.toSeq)) )
}

def tabList(tabsS: EventStream[Seq[Tab]] ) = ul(
    children <-- tabsS.split(_.id.get){(id, _, tabS) =>
        tabRow(id,tabS)
    }
)

def tabRow(id: Double, tabS: Signal[Tab]): Element = li(a(
    h3(child.text <-- tabS.map(_.title.getOrElse("(title undef)"))),
    p(child.text <-- tabS.map(_.url.getOrElse("(url undef")))
))

def sueppchen(mit: Source[String]) = div(h1("SÜPPCHEN mit ", child.text <-- mit))