
Old code:

if(flag){
	throw new Ex();
}else{
	...
	...
	return a;
}


Opt code:

if(flag){
	throw new Ex();
}
...
...
return a;