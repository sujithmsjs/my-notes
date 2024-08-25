
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

# Workflow of Git.

Step 1 − You modify a file from the working directory.

Step 2 − You add these files to the staging area.

Step 3 − You perform commit operation that moves the files from the staging area. After push operation, it stores the changes permanently to the Git repository.


# git status --short 

Note: Short status flags are:

?? - Untracked files
A - Files added to stage
M - Modified files
D - Deleted files


# git log


# git help

git command -help -  See all the available options for the specific command
git help --all -  See all possible commands

Note: You can also use --help instead of -help to open the relevant Git manual page
**Tracked - files** that Git knows about and are added to the repository
**Untracked - files** that are in your working directory, but not added to the repository
**Staged files** are files that are ready to be committed to the repository you are working on.

**Working Directory (Working Tree):**
The area where you perform your work, make changes, and create new files.
**Changes not staged for commit:**
Modifications made to tracked files that haven't been added to the staging area.
**Staging Area (Index):**
The intermediate area where changes are prepared before committing to the repository.

# git add

Note: The shorthand command for` git add --all` is `git add -A`

# git  clean
The git clean command is used to remove untracked files and directories from your working directory.

- You can only delete Untracked files/folders.
- You CAN NOT delete tracked files.

| Command | Untracked files| Untracked directories | Ignored files | Ignored folders |
| ------ | ------ | -----| ----- | ---- |
| -f |  Delete | |||
| -d |  Delete | Delete |||
| -fd |  Delete | Delete |||
| -x |  Delete |  | Delete||
| -fx |  Delete | |Delete||
| -dx |  Delete | Delete | Delete | Delete |
| -fdx |  Delete | Delete | Delete | Delete |

**Where to place command**
```git
git clean -fdx
```

**View before delete the file**
Add `n` at the end of the command.
```git
git clean -fdxn
```

### git reset
```git
git reset --hard HEAD
```
- `Untracked files` will not get effected.
- Untracked files are newly created files which are not added to `staging area`.
- Tracked files (Unstaged changes) will be reverted.
- Mainly two types of operations  can be done to `Tracked files/folders`.
  1. Delete
  2. Modifiy
  3. Renamed
- Mainly above operations which are performed on `Tracked files` will be reverted.

### git restore
Used to move files and folders from `staged` area to `unstaged` area.
use `git restore <file>...` to discard changes in working directory
### git stash

### git add
(use "git add <file>..." to update what will be committed)



git reset --hard HEAD
git clean -df
git clean -xdf

The -x option removes ignored files as well.
The -d flag tells Git to remove untracked directories
The -f option forces the cleaning process without asking for confirmation.

This will remove all untracked files and directories, including ignored files.



-X: Remove only ignored files. This ensures that you don't accidentally delete files that are not ignored.

If you are unsure about the changes that will be made, you can use the -n (dry-run) option to see what would be deleted without actually deleting anything:


git clean -fdX


Yes, you can write git clean -fdX as -fdx without any issues. Git command-line options are case-sensitive, but in this case, both -X and -x are recognized options, and they have different meanings:

-X: Remove only ignored files.
-x: Remove ignored and non-ignored files.



In Git, ignored files are those that are specified in the .gitignore file, and non-ignored files are everything else. Let me break it down:

Ignored files:

Files or directories listed in the .gitignore file are considered ignored.
The .gitignore file contains patterns that Git uses to determine which files and directories to exclude from version control.
Common examples of patterns in .gitignore include file extensions (e.g., .log, .tmp), directories (e.g., /node_modules/), or wildcard patterns.
Non-ignored files:

Files or directories not listed in the .gitignore file are considered non-ignored.
Non-ignored files are candidates for version control, and Git tracks changes to them unless explicitly ignored.
When you run a Git command like git clean -fdX (or git clean -fdx), it removes untracked files and directories. Untracked files are those not currently being tracked by Git (i.e., not included in any commit). This includes both ignored and non-ignored untracked files.

So, when you clean with the -X option, Git removes only the ignored untracked files, and with the -x option, Git removes both ignored and non-ignored untracked files.



### Difference between -fdx and -fdX


The difference between -fdx and -fdX in the context of the git clean command lies in the behavior of the options used:

-fdx:

-f: Force the clean, meaning it will delete files and directories without prompting for confirmation.
-d: Remove untracked directories.
-x: Remove both ignored and non-ignored files. This includes all untracked files, regardless of whether they are specified in the .gitignore file.
Example:

bash
Copy code
git clean -fdx
-fdX:

-f: Force the clean, as mentioned earlier.
-d: Remove untracked directories.
-X: Remove only ignored files. This means it will delete untracked files that are specified in the .gitignore file.
Example:

bash
Copy code
git clean -fdX
In summary:

-fdx removes both ignored and non-ignored untracked files and directories.
-fdX removes only ignored untracked files, preserving non-ignored untracked files.
Choose the appropriate option based on whether you want to include non-ignored untracked files in the clean operation or not.



Untracked files: Files that are not part of the current commit or any previous commit. These could be newly created files or files that were ignored and not tracked by Git.

Untracked directories: Directories that contain untracked files and are not part of the current commit or any previous commit.




git reset --hard HEAD
git clean -df

git clean -fdxn
git clean -fdx










git reset --hard HEAD: This command resets the working directory and the staging area to the last commit (HEAD). It discards all changes and sets your working directory to match the state of the last commit.

git clean -df: This command removes untracked files and directories from the working directory. The -d flag tells Git to remove untracked directories, and the -f flag stands for "force," ensuring that Git removes the files and directories without prompting for confirmation.








The git clean command is used to remove untracked files and directories from your working directory. The -fd options in git clean -fd mean:





$ git clean -fn
Delete untracked file excluding untracked folders, ignored files and folders.


nothing to commit, working tree clean
PS C:\Users\sujit\OneDrive\Desktop\My Notes Pranisha\demo-git-prac> git branch -r
  origin/HEAD -> origin/main
  origin/main

$git checkout -b titan origin/my-new-branch
fatal: 'origin/my-new-branch' is not a commit and a branch 'titan' cannot be created from it


$git fetch
 * [new branch]      my-new-branch -> origin/my-new-branch

$git checkout -b titan origin/my-new-branch
Switched to a new branch 'titan'

branch 'titan' set up to track 'origin/my-new-branch'.


$git status
On branch titan

$git branch -l
  main
* titan

&git checkout main
Switched to branch 'main'

$git checkout main23
error: pathspec 'main23' did not match any file(s) known to git

$git checkout titan
Switched to branch 'titan'

List Local Branches and Their Tracking Branches:
This command displays a list of local branches along with information about their upstream (tracking) branches.
$git branch -vv


$git status
On branch <local branch>
Your branch is up to date with <upstream branch>.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        tifan neptune.md

Note: gitignore files doesn't comes under untracked or tracked files.


# Undo git add .
If you want to undo a git add . command and unstage all changes that were added, you can use the following command:

$git reset

The files will still have the modifications, but they will be in the "unstaged" state.

If you want to completely discard all changes, including modifications to files, you can use the following command:
$git reset --hard

This will not only unstage changes but also discard any modifications in your working directory.










