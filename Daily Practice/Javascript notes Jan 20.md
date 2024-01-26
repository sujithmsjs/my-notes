Object to primitive conversion
*--> means Output
* > to

String Conversion

String(true)
'true'

String(true)
'true'

+true
1

+false
0

+'123213'
123213

-'123213'
-123213

+'123213'
123213

+'12321dfdf'
NaN

String(null)
'null'

String(undefined)
'undefined'

String(12321313)
'12321313'

String(NaN)
'NaN'


string > int
+'123213' --> 123213
-'123213' --> -123213
+'12321dfdf' --> NaN


string > bool
value = String(true);


bool > int
+true
-true


Numeric Conversion

"6" / "3"
2

Number('123213b')
NaN

Number('123213')
123213

Number('123213dfdsf')
NaN

Number(null)
0

Number(undefined)
NaN

Number(NaN)
NaN

Number(true)
1

Number(false)
0

alert( Number("   123   ") ); // 123
alert( Number("123z") );      // NaN (error reading a number at "z")
alert( Number(true) );        // 1
alert( Number(false) );       // 0

undefined	NaN
null	0
true and false	1 and 0

Boolean Conversion
0, null, undefined, NaN, "" -->	false
any other value 			-->	true

const print= () => {
	console.info("Boolean(-1) 		:",Boolean(-1) 		)
	console.info("Boolean(0) 		:",Boolean(0) 		)
	console.info("Boolean(1) 		:",Boolean(1) 		)
	console.info("Boolean('') 		:",Boolean('') 		)
	console.info("Boolean(' ')		:",Boolean(' ')		)
	console.info("Boolean('text') 	:",Boolean('text') 	)
	console.info("Boolean(null) 	:",Boolean(null) 	)
	console.info("Boolean(undefined):",Boolean(undefined))
	console.info("Boolean(NaN) 		:",Boolean(NaN) 	)	
	console.info("Boolean(Infinity) :",Boolean(Infinity))
	console.info("Boolean(-Infinity):",Boolean(-Infinity))
}