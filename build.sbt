import org.scalajs.linker.interface.ModuleSplitStyle.*

lazy val schrome = project.in(file("."))
    .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
    .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
    .settings(
        scalaVersion := "3.2.2",
        libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1",

        scalaJSUseMainModuleInitializer := true,
        scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule)
                                  .withModuleSplitStyle(SmallModulesFor(List("schrome"))) },

        libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.16" % "test",
        Test / jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
        Test / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.NoModule).withModuleSplitStyle(FewestModules) },

        stIncludeDev := true, // including dev, but only need @types/chrome - ignoring the rest
        stIgnore ++= List("@crxjs/vite-plugin","@scala-js/vite-plugin-scalajs","jsdom","vite"),
        externalNpm := baseDirectory.value
    )