# Java vs Python polyglot PoC

## Quick start 

Install GraalVM with [SDKman](https://sdkman.io/install)
```bash
$ sdk install java 19.3.1.r8-grl
$ sdk use java 19.3.1.r8-grl
```
Specify Graal SDK in Intellij Idea  
File -> Project settings -> SDK

Run `PolyglotFeatures.main`

## Result
```bash
02:56:39: Executing task 'PolyglotFeatures.main()'...

> Task :compileJava UP-TO-DATE
> Task :processResources
> Task :classes

> Task :PolyglotFeatures.main()
Page SEO feature: 6
Site 08447d05-58b9-4b81-87a9-0f8671b3c662 saved 9 times.

BUILD SUCCESSFUL in 13s
3 actionable tasks: 2 executed, 1 up-to-date
02:56:52: Task execution finished 'PolyglotFeatures.main()'.

```