[![Build Status](https://travis-ci.org/EuDgee/Screenshot-Grabber.svg?branch=master)](https://travis-ci.org/EuDgee/Screenshot-Grabber)
[![Codacy Badge](https://www.codacy.com/project/badge/35f932cfb04f4d0293df85e5d3e0cd6a)](https://www.codacy.com/app/eudgee/Screenshot-Grabber)

## Screenshot-Grabber

Rest service to grab screenshots and save it as a file.

Parts:
- PhantomJS "browser"
  - loads sites
  - saves screenshots to files
- Akka actors to:
  - http supervisor/router
  - listen http
  - URL supervisor/router
  - check URL correctness
  - phantomjs supervisor/router
  - manage phantomjs instances (spawn, make screenshots, kill)
