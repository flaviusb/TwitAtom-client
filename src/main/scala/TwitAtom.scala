package net.flaviusb.twitatom

import android.app.{Activity, ListActivity}
import android.os.{Bundle, Message, Handler, Environment}
import android.graphics.Canvas
import android.widget._
import android.content.{Context, Intent}
import android.content.res.Resources

import java.io._

import android.util.Log


class TwitAtom extends Activity {
  var current_service_document: Option[String] = None
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    current_service_document = Option(if (savedInstanceState != null && savedInstanceState.getString("net.flaviusb.twitatom.atom_service_document") != null) {
      savedInstanceState.getString("net.flaviusb.twitatom.atom_service_document") 
    } else {
      getPreferences(android.content.Context.MODE_PRIVATE).getString("Atom Service Document", null)
    })
    if(current_service_document == None) {
      setContentView(R.layout.service_document_selector)
    } else {
      setContentView(R.layout.main)
    }
  }
}
