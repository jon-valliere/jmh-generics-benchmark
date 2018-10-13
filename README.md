# JMH Generics Benchmark

Utilizing the Java microbenchmark harness, this tool tests the performance of casting via Java's Generics interface.

	mvn clean install
	java -jar target/benchmarks.jar


## Results	
	Benchmark                                           Mode  Cnt           Score          Error  Units
	BakedGenericAbstractTest.testBaked                 thrpt   25   266546871.324 ±  1074252.464  ops/s
	BakedGenericAbstractTest.testChecked               thrpt   25   266401293.377 ±   965579.091  ops/s
	BakedGenericAbstractTest.testExplicit              thrpt   25   267428631.832 ±   889488.958  ops/s
	BakedGenericAbstractTest.testUnchecked             thrpt   25   266835768.038 ±   692698.604  ops/s
	BakedGenericInterfaceTest.testBaked                thrpt   25   436224760.928 ±  1154834.127  ops/s
	BakedGenericInterfaceTest.testChecked              thrpt   25   437233111.351 ±   950077.861  ops/s
	BakedGenericInterfaceTest.testExplicit             thrpt   25  3862523572.417 ±  6638293.715  ops/s
	BakedGenericInterfaceTest.testUnchecked            thrpt   25   436670248.975 ±  1699424.348  ops/s
	ExplicitGenericAbstractTest.testChecked            thrpt   25  3863604719.400 ±  5981320.891  ops/s
	ExplicitGenericAbstractTest.testExplicit           thrpt   25  3857546118.700 ± 10817074.013  ops/s
	ExplicitGenericAbstractTest.testUnchecked          thrpt   25  3863595037.248 ±  6490885.950  ops/s
	ExplicitGenericInterfaceTest.testChecked           thrpt   25   434639179.158 ±  1463899.929  ops/s
	ExplicitGenericInterfaceTest.testExplicit          thrpt   25  3859999619.500 ±  7548272.727  ops/s
	ExplicitGenericInterfaceTest.testUnchecked         thrpt   25   435984877.555 ±  1320205.614  ops/s
	ExtendsSubClassGenericInterfaceTest.testChecked    thrpt   25   435087843.047 ±  1610483.278  ops/s
	ExtendsSubClassGenericInterfaceTest.testExplicit   thrpt   25  3862198427.936 ±  6743883.310  ops/s
	ExtendsSubClassGenericInterfaceTest.testUnchecked  thrpt   25   435555025.013 ±  1608941.950  ops/s
	GenericInterfaceTest.testCheckedInterface          thrpt   25   436673343.116 ±  1367911.515  ops/s
	GenericInterfaceTest.testCheckedType               thrpt   25  3867603597.624 ±  4231173.358  ops/s
	GenericInterfaceTest.testUncheckedInterface        thrpt   25   436865121.204 ±  1152837.774  ops/s
	GenericInterfaceTest.testUncheckedType             thrpt   25  3865949195.806 ±  5964889.174  ops/s
	GenericTypeTest.testChecked                        thrpt   25  3865273735.318 ±  5202807.171  ops/s
	GenericTypeTest.testUnchecked                      thrpt   25  3863034221.170 ±  5955522.736  ops/s
	StrictInterfaceTest.testInterface                  thrpt   25   436029804.561 ±  1542724.795  ops/s
	StrictInterfaceTest.testType                       thrpt   25  3865070528.725 ±  6400293.825  ops/s
	StrictSubClassInterfaceTest.testInterface          thrpt   25   435713126.417 ±  1544595.848  ops/s
	StrictSubClassInterfaceTest.testType               thrpt   25  3864218079.403 ±  6794438.832  ops/s
	StrictSubClassTypeTest.testType                    thrpt   25  3861802527.013 ±  7376087.128  ops/s
	StrictTypeTest.testType                            thrpt   25  3860727825.313 ±  6063470.496  ops/s


Clearly ```invokeinterface``` is very expensive.