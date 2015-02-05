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
