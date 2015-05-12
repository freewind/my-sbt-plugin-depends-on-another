Demo: my sbt plugin depends on another plugin
=============================================

I tried to create a task which uses a value generated by a task from another plugin.

But it has some issues, when I load this plugin in a demo sbt project, it will report:

```
➜  sbt-dependency-test  sbt
[info] Loading global plugins from /Users/twer/.sbt/0.13/plugins
[info] Updating {file:/Users/twer/.sbt/0.13/plugins/}global-plugins...
[info] Resolving org.scala-sbt.ivy#ivy;2.3.0-sbt-14d4d23e25f354cd296c7[info] Resolving org.fusesource.jansi#jansi;1.4 ...
[info] Done updating.
[info] Loading project definition from /Users/twer/workspace/sbt-dependency-test/project
[info] Updating {file:/Users/twer/workspace/sbt-dependency-test/project/}sbt-dependency-test-build...
[info] Resolving test20140913#my-sbt-plugin-depends-on-another;0.1.2.1[info] Resolving org.scala-sbt.ivy#ivy;2.3.0-sbt-14d4d23e25f354cd296c7[info] Resolving org.fusesource.jansi#jansi;1.4 ...
[info] Done updating.
Reference to undefined setting:

  *:dependencyTree from *:hello2 (/Users/twer/workspace/my-sbt-plugin-depends-on-another/src/main/scala/test20140913/MySbtPlugin.scala:38)
     Did you mean provided:dependencyTree ?

	at sbt.Init$class.Uninitialized(Settings.scala:262)
	at sbt.Def$.Uninitialized(Def.scala:10)
	at sbt.Init$class.delegate(Settings.scala:188)
	at sbt.Def$.delegate(Def.scala:10)
	at sbt.Init$class.compiled(Settings.scala:135)
	at sbt.Def$.compiled(Def.scala:10)
	at sbt.Init$class.make(Settings.scala:141)
	at sbt.Def$.make(Def.scala:10)
	at sbt.Load$.apply(Load.scala:135)
	at sbt.Load$.defaultLoad(Load.scala:36)
	at sbt.BuiltinCommands$.doLoadProject(Main.scala:481)
	at sbt.BuiltinCommands$$anonfun$loadProjectImpl$2.apply(Main.scala:475)
	at sbt.BuiltinCommands$$anonfun$loadProjectImpl$2.apply(Main.scala:475)
	at sbt.Command$$anonfun$applyEffect$1$$anonfun$apply$2.apply(Command.scala:58)
	at sbt.Command$$anonfun$applyEffect$1$$anonfun$apply$2.apply(Command.scala:58)
	at sbt.Command$$anonfun$applyEffect$2$$anonfun$apply$3.apply(Command.scala:60)
	at sbt.Command$$anonfun$applyEffect$2$$anonfun$apply$3.apply(Command.scala:60)
	at sbt.Command$.process(Command.scala:92)
	at sbt.MainLoop$$anonfun$1$$anonfun$apply$1.apply(MainLoop.scala:98)
	at sbt.MainLoop$$anonfun$1$$anonfun$apply$1.apply(MainLoop.scala:98)
	at sbt.State$$anon$1.process(State.scala:184)
	at sbt.MainLoop$$anonfun$1.apply(MainLoop.scala:98)
	at sbt.MainLoop$$anonfun$1.apply(MainLoop.scala:98)
	at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
	at sbt.MainLoop$.next(MainLoop.scala:98)
	at sbt.MainLoop$.run(MainLoop.scala:91)
	at sbt.MainLoop$$anonfun$runWithNewLog$1.apply(MainLoop.scala:70)
	at sbt.MainLoop$$anonfun$runWithNewLog$1.apply(MainLoop.scala:65)
	at sbt.Using.apply(Using.scala:24)
	at sbt.MainLoop$.runWithNewLog(MainLoop.scala:65)
	at sbt.MainLoop$.runAndClearLast(MainLoop.scala:48)
	at sbt.MainLoop$.runLoggedLoop(MainLoop.scala:32)
	at sbt.MainLoop$.runLogged(MainLoop.scala:24)
	at sbt.StandardMain$.runManaged(Main.scala:53)
	at sbt.xMain.run(Main.scala:28)
	at xsbt.boot.Launch$$anonfun$run$1.apply(Launch.scala:109)
	at xsbt.boot.Launch$.withContextLoader(Launch.scala:128)
	at xsbt.boot.Launch$.run(Launch.scala:109)
	at xsbt.boot.Launch$$anonfun$apply$1.apply(Launch.scala:35)
	at xsbt.boot.Launch$.launch(Launch.scala:117)
	at xsbt.boot.Launch$.apply(Launch.scala:18)
	at xsbt.boot.Boot$.runImpl(Boot.scala:41)
	at xsbt.boot.Boot$.main(Boot.scala:17)
	at xsbt.boot.Boot.main(Boot.scala)
[error] Reference to undefined setting:
[error]
[error]   *:dependencyTree from *:hello2 (/Users/twer/workspace/my-sbt-plugin-depends-on-another/src/main/scala/test20140913/MySbtPlugin.scala:38)
[error]      Did you mean provided:dependencyTree ?
[error]
[error] Use 'last' for the full log.
Project loading failed: (r)etry, (q)uit, (l)ast, or (i)gnore?     
```

Not sure how to fix it.
