import sbt._

trait Defaults {
  def androidPlatformName = "android-10"
}
class TwitAtomClient(info: ProjectInfo) extends ParentProject(info) {
  override def shouldCheckOutputDirectories = false
  override def updateAction = task { None }

  lazy val main  = project(".", "TwitAtomClient", new MainProject(_))
  //lazy val tests = project("tests",  "Templates-Tests", new TestProject(_), main)

  class MainProject(info: ProjectInfo) extends AndroidProject(info) with Defaults with MarketPublish with TypedResources {
    val keyalias  = "TwitAtomClient"
    val scalatest = "org.scalatest" % "scalatest" % "1.3" % "test"
  }

  //class TestProject(info: ProjectInfo) extends AndroidTestProject(info) with Defaults
}
