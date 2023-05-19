import org.scalajs.linker.interface.ModuleSplitStyle

lazy val sueppchen = project.in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .settings(
    scalaVersion := "3.2.2",

    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit as many small modules as possible for classes in the "sueppchen" package
     * - emit as few (large) modules as possible for all other classes
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("sueppchen")))
    },

    libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1",


  )