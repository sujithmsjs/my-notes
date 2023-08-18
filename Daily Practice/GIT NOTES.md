
# Fetch the latest updates from the remote repository
git fetch origin

# Create a new local branch based on the remote branch and switch to it
git checkout -b local-branch-name origin/branch_name
Ex:
git checkout -b main-rest-apis origin/main-rest-apis


# Switch to the existing remote branch
git checkout branch_name
Ex:
git branch -l
git checkout main
git checkout main-rest-apis


# Fetch the latest updates from the remote repository
git fetch origin

# Create and switch to a local branch based on the remote branch
git checkout -b local-branch-name origin/main-rest-apis



> git branch -a
* main
  main-rest-apis
  remotes/origin/HEAD -> origin/main
  remotes/origin/main
  remotes/origin/main-react-ui
  remotes/origin/main-rest-apis

All the branches starting with remotes are remote branches and remaining all are local branches.
Now you can directly switch to only local to another. Local branches already linked to their perticular Remote branches.

Ex:
git switch main
git switch main-rest-apis
git checkout main
git checkout main-rest-apis

> git branch -l
  main
* main-rest-apis

> git checkout -b ui origin/main-react-ui
Switched to a new branch 'ui'
branch 'ui' set up to track 'origin/main-react-ui'.

Note: Now 'ui' local branch is created and set up to track the remote branch.

> git branch -a
  main
  main-rest-apis
* ui
  remotes/origin/HEAD -> origin/main
  remotes/origin/main
  remotes/origin/main-react-ui
  remotes/origin/main-rest-apis

Note:
- Local branch name should not be same as Remote branch

local branch name: ui
remote branch name: main-react-ui

- Shorter Local branch names also convenient to swith between them
Ex: 
git switch ui



```bash
git remote show origin
```
```bash
git clean -f -fd
git reset --hard
git switch -c '<new-branch-name>'
git switch <existing-branch>
```
```bash
git stash list
git stash save "bugfix"
git stash apply bugfix
git stash clear
git stash pop
git stash apply stash@{n}
git stash apply <index>
git stash drop  <index>
git stash -u
git stash save -m '<Your Message>'
```



GIT : Distributed Version Control System.
SCM: Software/Source Configuration Management.

Version Control:
Snapshot version
Final version

Old days:
CVCS: Centralized Version Control System
- What if it fails? All lost.

Now:
DVCS: Distributed Version Control System
- Local Repository and Central Repository
- Everyone have their own copy.

---
Trunk Based Development:
- Version Control
- Branch
- Master Branch
---
Master Branch:

- Don't work on same branch.
- Always use versions, so you can't lost old code.




---
Working with GIT

#1 Create New Repository
ReadMe.md md means mark down

#2 Create a file

#3 Commit or Commit with New branch.

---
Pull Request

- New Version


----

$ cd ~
Navigate to your home (~) directory

$ mkdir repos
$ cd repos
$ cd ~/repos

$ git add locations.txt
$ git status 
$ git commit -m 'Initial commit' 

$ git push origin main
This command specifies that you are pushing to the main branch (the branch on Bitbucket) on origin (the Bitbucket server).

$ git pull --all
$ git branch
$ git branch future-plans
$ git checkout future-plans
$ git add stationlocations
$ git commit stationlocations -m 'making a change in a branch'
$ git checkout main 
$ git merge future-plans
$ git branch -d future-plans : delete

To see all local and remote branches, run:
$ git branch
$ git branch -a
$ git branch -r
$ git branch -vv
$ git branch -vva:

Stash:
------

Put your changes aside, and checkout another branch. Apply your changes later.

Working in process(WIP): Your work not yet ready to be commited.


$ git stash
$ git stash push -m <message>
$ git stash list
$ git stash apply <index>
$ git stash -u
$ git stash show <index>
$ git stash show -p <index>

$ git stash branch <new-branch> <index>
$ git stash pop
$ git stash clear


MERGE:

git merge his-branch
git merge --abort
git add .
git commit -m "merged his branch"
git log


CLEAN:

WIP: Work in Progress.

WIP > Stage > Local Repo > Remote Repo

Add: WIP > Stage
Commit: Stage > Local Repo
Push: Local Repo > Remote Repo

$ git clean -n
Shows which file would be removed.

$ git clean -n -d
Shows which file and would be removed.

$ git clean -f
Remove file

$ git clean -f -d

$ git status -s








