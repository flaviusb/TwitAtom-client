#!/usr/bin/env byeloblog.ik

; This now depends on [Byeloblog](http://byeloblog.net) to build

; Build out the various manifest files
GenX build(
  "src/main/AndroidManifest.xml"                      => "manifest.ik",
  "src/main/res/layout/service_document_selector.xml" => "service_document_selector.ik",
  "src/main/res/layout-port/main.xml"                 => "mainlayout.ik",
  "src/main/res/layout-land/main.xml"                 => "mainlayout.ik")

; Shell out to sbt for the heavy lifting
if(Shell out("sbt", "clean", "update", "package-debug") == 0,
  Shell out("kdialog", "--passivepopup", "Finished building TwitAtom-client.", "5"),
  Shell out("kdialog", "--passivepopup", "Failed building TwitAtom-client.", "5"))

