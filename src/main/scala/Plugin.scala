import io.github.gitbucket.solidbase.model.Version
import gitbucket.core.plugin._
import gitbucket.core.controller.Context
import javax.servlet.ServletContext
import gitbucket.core.service.SystemSettingsService.SystemSettings

class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "gitbucket-commit-description-plugin"
  override val pluginName: String = "gitbucket commit description Plugin"
  override val description: String = "display commit description plug-in"
  override val versions: List[Version] = List(new Version("1.0.0"))

  override def javaScripts(registry: PluginRegistry, context: ServletContext, settings: SystemSettings): Seq[(String, String)] = {
    Seq(
        ".*/(pull|commits)/.*" -> s"""
        | var x = document.getElementsByClassName("commit-description");
        | for(var i = 0; i < x.length; ++i){
        |   x[i].style = "display: ;";
        | }
    """.stripMargin)
  }
}
