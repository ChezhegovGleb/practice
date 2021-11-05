# Liptsoft homework

A simplified Java version of the class search has been implemented.

The solution is based on the Knutt-Morris-Pratt Algorithm and the Two Pointer Algorithm

The program runs from the command line:
```
./class-finder <filename> '<pattern>'
```

where `<filename>` refers to the file containing class names separated by line breaks, e.g.:

```
a.b.FooBarBaz
c.d.FooBar
```

Search pattern `<pattern>` must include class name camelcase upper case letters
in the right order and it may contain lower case letters to narrow down the search results,
for example `'FB'`, `'FoBa'` and `'FBar'` searches must all match
`a.b.FooBarBaz` and `c.d.FooBar` classes.

Upper case letters written in the wrong order will not find any results, for example
`'BF'` will not find `c.d.FooBar`.

If the search pattern consists of only lower case characters then the search becomes
case insensitive (`'fbb'` finds `FooBarBaz` but `'fBb'` will not).

If the search pattern ends with a space `' '` then the last word in the pattern must
also be the last word of the found class name (`'FBar '` finds `FooBar` but not `FooBarBaz`).

The search pattern may include wildcard characters `'*'` which match missing letters
(`'B*rBaz'` finds `FooBarBaz`i but `BrBaz` does not).

Found classes are sorted alphabetically without regard to package name.

Unit tests are provided for the Matcher class.