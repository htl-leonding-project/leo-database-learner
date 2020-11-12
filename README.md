# LeoDatabaseLearner

* https://github.com/htl-leonding-project/leo-database-learner

## Description:

Practice tool to learn database commands and to check your level of knowledge.

## gh-pages
 
   * [index leo-database-learner ](https://htl-leonding-project.github.io/leo-database-learner/)
   * [Project-proposal](https://htl-leonding-project.github.io/leo-database-learner/project-proposal)
   * [System-specification](https://htl-leonding-project.github.io/leo-database-learner/system-specification)


## How to create gh-pages

two scripts are available:

    build-html-docker.sh -> builds the .html-pages in the folder gh-pages
    publish-gh-pages.sh -> builds and deploys the gh-pages

additionally is a script build-pdf-docker.sh for creating a pdf document.

before running the scripts:

* Copy the `.env.template`-file to `.env`
* fill in your git-username and git-email

```
GIT_GLOBAL_MAIL=<your email>
GIT_GLOBAL_USER_NAME=<your git - username>
```

* run the script `run-inside-docker.sh`