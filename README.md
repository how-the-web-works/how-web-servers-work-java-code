## How the web works - Server Side

In this repository you'll find the sample code.

### Running one application

If you're using Visual Studio Code, you can just open the main file and click the `Run` button to run it.

If you're in an *nix machine, you can use the `run.sh` script.
The script will run Gradle's `distributionZip` task for all projects then go into the build folder of the specified project, unzip the zip file generated and run it.

The following is an example:

```bash
$ cd java
$ ./run.sh java/chapter-01/hello_process/
Next random number was: 926
Next random number was: 935
Next random number was: 704
Next random number was: 313
Next random number was: 546
^CProcess is shutting down...

```
