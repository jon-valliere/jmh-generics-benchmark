# JMH Generics Benchmark

Utilizing the Java microbenchmark harness, this tool tests the performance of casting via Java's Generics interface.

	mvn clean install
	java -jar target/benchmarks.jar


## Results	
	Benchmark                                    Mode  Cnt           Score          Error  Units
	BakedGenericAbstractTest.testChecked        thrpt   25   266853911.958 ±   948322.660  ops/s
	BakedGenericAbstractTest.testExplicit       thrpt   25   267307406.038 ±   708497.472  ops/s
	BakedGenericAbstractTest.testUnchecked      thrpt   25   267085306.907 ±   940003.901  ops/s
	ExplicitGenericAbstractTest.testChecked     thrpt   25  3865766623.580 ±  4767125.246  ops/s
	ExplicitGenericAbstractTest.testExplicit    thrpt   25  3865853664.119 ±  6111149.192  ops/s
	ExplicitGenericAbstractTest.testUnchecked   thrpt   25  3865400415.174 ±  5324217.156  ops/s
	ExplicitGenericInterfaceTest.testChecked    thrpt   25   437562599.845 ±   931880.400  ops/s
	ExplicitGenericInterfaceTest.testExplicit   thrpt   25  3864137757.380 ±  5445416.138  ops/s
	ExplicitGenericInterfaceTest.testUnchecked  thrpt   25   437132056.995 ±  1189629.255  ops/s
	GenericInterfaceTest.testChecked            thrpt   25  3860716645.902 ±  7905958.243  ops/s
	GenericInterfaceTest.testUnchecked          thrpt   25  3862435725.220 ±  8805891.195  ops/s
	GenericTypeTest.testChecked                 thrpt   25  3863093528.704 ±  5675811.547  ops/s
	GenericTypeTest.testUnchecked               thrpt   25  3863258411.002 ±  6496366.188  ops/s
	StrictInterfaceTest.testInterface           thrpt   25   436557131.655 ±  1305288.868  ops/s
	StrictInterfaceTest.testType                thrpt   25  3863243070.491 ±  7415064.465  ops/s
	StrictTypeTest.testType                     thrpt   25  3845707936.116 ± 22766603.582  ops/s

Clearly ```invokeinterface``` is very expensive.