First things first, thank you for taking the time to look into this project and making the decision to contribute!  🎉

To get started with the project, please [check out our README](https://github.com/ocadotechnology/rapid-router-android#getting-started) which gives a brief guide on cloning the codebase and setting up your Android Studio IDE. Once you're done there, you're ready to start developing!

We welcome all new ideas and approaches, however we do ask that you read the rest of this page to get familiar with our process.

## Branching
Rather than push feature changes to master, we use branch development. In order to submit a change, please first checkout a new branch and commit your changes there.

## Running the Checks
The build will run two stages against the project - the first is the KTLinter and the second is checking that it builds and launches successfully. To avoid issues on the branch, the best thing to do is to run `./gradelw ktlint` and `./gradelw build` in your command line to ensure that they pass. If they do, you're good to go.

## Opening a Pull Request
To have your changes merged into master, you must next open a pull request. Give it a short but clear name, and add any additional information or comments in the description. Also link to any issue that it fixes here. The request can only be approved if the build checks pass and the review has been checked by another contributor. Once these two criteria are met, the request can be accepted and it will automatically merge everything to master.

## Information on the Build
Our builds are run on [Travis](https://travis-ci.org/ocadotechnology/rapid-router-android), with the current status displayed here and on the README.

[![Build Status](https://travis-ci.org/ocadotechnology/rapid-router-android.svg?branch=master)](https://travis-ci.org/ocadotechnology/rapid-router-android)

The script for running this build can be found [here](https://github.com/ocadotechnology/rapid-router-android/blob/master/.travis.yml).

## Final Words
Thank you again for deciding to contribute! If you need any help or have any questions then please don't hesitate to contact one of the team.
