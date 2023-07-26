```git

git restore --staged .
git reset HEAD~1
git reset abc123

```

### Undo a commit & redo

```git
$ git commit -m "Something terribly misguided"
$ git reset HEAD~
[ edit files as necessary ]
$ git add .
$ git commit -c ORIG_HEAD
```


git reset is the command responsible for the undo. It will undo your last commit while leaving your working tree (the state of your files on disk) untouched. You'll need to add them again before you can commit them again).
Make corrections to working tree files.
git add anything that you want to include in your new commit.
Commit the changes, reusing the old commit message. reset copied the old head to .git/ORIG_HEAD; commit with -c ORIG_HEAD will open an editor, which initially contains the log message from the old commit and allows you to edit it. If you do not need to edit the message, you could use the -C option.

### git reset --hard
- This command is irreversible

It allows you to reset your repository to a specific commit, removing all subsequent commits and changes to files in the working directory. The --hard option means that Git will discard all changes and files in the working directory that are not part of the specified commit, effectively resetting your repository to that commit.





git branch
git branch mysecoundbranch
git branch
git switch mysecoundbranch
git branch
git checkout -b mythirdbranch
-b(if not branch exists, create one)
git branch


git branch
git switch mysecoundbranch
git checkout master
git branch

git branch -d <delete_branch_name>
git branch mythirdbranch

git branch
git log


git swtich master
git branch
git merge mysecoundbranch

--

git branch -cm mynewbranch
git branch
git checkout mynewbranch
git branch






