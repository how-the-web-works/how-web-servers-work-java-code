## How the web works - Server Side

In this repository you'll find the sample code.

### Running one application

To run one application from the command line, you can use Gradle's run task.
The following is an example:

```bash
$ ./gradlew :chapter-01:hello_process:run --console plain
> Task :chapter-01:hello_process:compileJava
> Task :chapter-01:hello_process:processResources NO-SOURCE
> Task :chapter-01:hello_process:classes

> Task :chapter-01:hello_process:run
What's your name? 
John
Hello John!

BUILD SUCCESSFUL in 5s
2 actionable tasks: 2 executed
```
