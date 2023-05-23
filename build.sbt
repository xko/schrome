import org.scalajs.linker.interface.ModuleSplitStyle.*

lazy val schrome = project.in(file("."))
    .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
    .settings(
        scalaVersion := "3.2.2",
        libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1",

        scalaJSUseMainModuleInitializer := true,
        scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule)
                                  .withModuleSplitStyle(SmallModulesFor(List("schrome"))) },

        libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.16" % "test",
        Test / jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
        Test / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.NoModule).withModuleSplitStyle(FewestModules) },
    )