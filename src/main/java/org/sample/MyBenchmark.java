/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import org.openjdk.jmh.annotations.Benchmark;

public class MyBenchmark
{
	@Benchmark
	public void uncheckedMethod()
	{
		final Receiver x = this.createUncheckedReceiver();

		final Object y = this.createUncheckedObject();

		Object z = null;

		for (int i = 0; i != 1_000_000; i++)
		{
			if (z == y)
			{
				z = x.foo(y);
			}
			else
			{
				z = x.foo(y);
			}
		}
	}

	protected Object createUncheckedObject()
	{
		return new TypeA();
	}

	protected Receiver createUncheckedReceiver()
	{
		return new ReceiverA();
	}

	@Benchmark
	public void checkedMethod()
	{
		final Receiver<TypeA> x = this.createCheckedReceiver();

		final TypeA y = this.createCheckedObject();

		TypeA z = null;

		for (int i = 0; i != 1_000_000; i++)
		{
			if (z == y)
			{
				z = x.foo(y);
			}
			else
			{
				z = x.foo(y);
			}
		}
	}

	protected TypeA createCheckedObject()
	{
		return new TypeA();
	}

	protected Receiver<TypeA> createCheckedReceiver()
	{
		return new ReceiverA();
	}

	@Benchmark
	public void strictMethod()
	{
		final ReceiverB x = this.createStrictReceiver();

		final TypeA y = this.createStrictObject();

		TypeA z = null;

		for (int i = 0; i != 1_000_000; i++)
		{
			if (z == y)
			{
				z = x.foo(y);
			}
			else
			{
				z = x.foo(y);
			}
		}
	}

	protected TypeA createStrictObject()
	{
		return new TypeA();
	}

	protected ReceiverB createStrictReceiver()
	{
		return new ReceiverB();
	}

	static public class TypeA
	{

	}

	static public class ReceiverA extends TypeA implements Receiver<TypeA>
	{
		@Override
		public TypeA foo(final TypeA value)
		{
			if (value == this)
			{
				return value;
			}
			else
			{
				return value;
			}
		}
	}

	static public class ReceiverB extends TypeA
	{
		public TypeA foo(final TypeA value)
		{
			if (value == this)
			{
				return value;
			}
			else
			{
				return value;
			}
		}
	}

	static public interface Receiver<X>
	{
		X foo(X value);
	}
}
