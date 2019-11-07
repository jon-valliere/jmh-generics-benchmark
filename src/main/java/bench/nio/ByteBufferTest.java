package bench.nio;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import org.openjdk.jmh.annotations.Benchmark;

import sun.misc.Unsafe;

public class ByteBufferTest
{
	static final int		LIMIT	= 1024 * 1024 * 2;

	static final ByteBuffer	DIRECT	= ByteBuffer.allocateDirect(ByteBufferTest.LIMIT);
	static final ByteBuffer	HEAP	= ByteBuffer.allocate(ByteBufferTest.LIMIT);

	static final long		NATIVE;
	static final Unsafe		UNSAFE;

	static
	{
		final byte x = (byte) 0x33;

		while (ByteBufferTest.DIRECT.hasRemaining())
		{
			ByteBufferTest.DIRECT.put(x);
		}

		while (ByteBufferTest.HEAP.hasRemaining())
		{
			ByteBufferTest.HEAP.put(x);
		}

		UNSAFE = ByteBufferTest.get_unsafe();
		NATIVE = ByteBufferTest.UNSAFE.allocateMemory(ByteBufferTest.LIMIT);
	}

	static final Unsafe get_unsafe()
	{
		Unsafe s = null;

		try
		{
			s = ByteBufferTest.loadUnsafe("theUnsafe"); // JDK

			if (s == null)
			{
				s = ByteBufferTest.loadUnsafe("THE_ONE"); // Android

				if (s == null)
				{
					final Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
					unsafeConstructor.setAccessible(true);
					s = unsafeConstructor.newInstance();
				}
			}
		}
		catch (final Exception e)
		{
			throw new Error("Failed to load " + Unsafe.class.getName(), e);
		}

		return s;
	}

	static Unsafe loadUnsafe(final String name) throws Exception
	{
		Field field = null;
		try
		{
			field = Unsafe.class.getDeclaredField(name);
		}
		catch (final NoSuchFieldException e)
		{
			return null;
		}

		field.setAccessible(true);
		return (Unsafe) field.get(null);
	}

	@Benchmark
	public void testUnsafeWrite()
	{
		final Unsafe u = ByteBufferTest.UNSAFE;

		final long t = ByteBufferTest.NATIVE;

		byte x = (byte) 0xF3;

		for (int i = 0; i < ByteBufferTest.LIMIT; i++)
		{
			u.putByte(i + t, x++);
		}
	}

	@Benchmark
	public void testArrayWrite()
	{
		final byte[] t = ByteBufferTest.HEAP.array();

		byte x = (byte) 0xF3;

		for (int i = 0; i < ByteBufferTest.LIMIT; i++)
		{
			t[i] = x++;
		}
	}

	@Benchmark
	public void testDirectByteBufferWrite()
	{
		final ByteBuffer t = ByteBufferTest.DIRECT;

		t.clear();

		byte x = (byte) 0xF3;

		while (t.hasRemaining())
		{
			t.put(x++);
		}
	}

	@Benchmark
	public void testDirectByteBufferWriteShort()
	{
		final ByteBuffer t = ByteBufferTest.DIRECT;

		t.clear();

		short x = (short) 0xF3F3;

		while (t.hasRemaining())
		{
			t.putShort(x++);
		}
	}

	@Benchmark
	public void testDirectByteBufferWriteInteger()
	{
		final ByteBuffer t = ByteBufferTest.DIRECT;

		t.clear();

		int x = 0xF3F3F3F3;

		while (t.hasRemaining())
		{
			t.putInt(x++);
		}
	}

	@Benchmark
	public void testHeapByteBufferWrite()
	{
		final ByteBuffer t = ByteBufferTest.HEAP;

		t.clear();

		byte x = (byte) 0xF3;

		while (t.hasRemaining())
		{
			t.put(x++);
		}
	}

	@Benchmark
	public void testHeapByteBufferWriteShort()
	{
		final ByteBuffer t = ByteBufferTest.HEAP;

		t.clear();

		short x = (short) 0xF3F3;

		while (t.hasRemaining())
		{
			t.putShort(x++);
		}
	}

	@Benchmark
	public void testHeapByteBufferWriteInteger()
	{
		final ByteBuffer t = ByteBufferTest.HEAP;

		t.clear();

		int x = 0xF3F3F3F3;

		while (t.hasRemaining())
		{
			t.putInt(x++);
		}
	}

	@Benchmark
	public byte testArrayRead()
	{
		final byte[] t = ByteBufferTest.HEAP.array();

		byte x = 0;

		for (int i = 0; i < ByteBufferTest.LIMIT; i++)
		{
			x += t[i];
		}

		return x;
	}

	@Benchmark
	public byte testUnsafeRead()
	{
		final Unsafe u = ByteBufferTest.UNSAFE;

		final long t = ByteBufferTest.NATIVE;

		byte x = 0;

		for (int i = 0; i < ByteBufferTest.LIMIT; i++)
		{
			x += u.getByte(i + t);
		}

		return x;
	}

	@Benchmark
	public byte testDirectByteBufferRead()
	{
		final ByteBuffer t = ByteBufferTest.DIRECT;

		t.clear();

		byte x = 0;

		while (t.hasRemaining())
		{
			x += t.get();
		}

		return x;
	}

	@Benchmark
	public short testDirectByteBufferReadShort()
	{
		final ByteBuffer t = ByteBufferTest.DIRECT;

		t.clear();

		short x = 0;

		while (t.hasRemaining())
		{
			x += t.getShort();
		}

		return x;
	}

	@Benchmark
	public int testDirectByteBufferReadInteger()
	{
		final ByteBuffer t = ByteBufferTest.DIRECT;

		t.clear();

		int x = 0;

		while (t.hasRemaining())
		{
			x += t.getInt();
		}

		return x;
	}

	@Benchmark
	public byte testHeapByteBufferRead()
	{
		final ByteBuffer t = ByteBufferTest.HEAP;

		t.clear();

		byte x = 0;

		while (t.hasRemaining())
		{
			x += t.get();
		}

		return x;
	}

	@Benchmark
	public short testHeapByteBufferReadShort()
	{
		final ByteBuffer t = ByteBufferTest.HEAP;

		t.clear();

		short x = 0;

		while (t.hasRemaining())
		{
			x += t.getShort();
		}

		return x;
	}

	@Benchmark
	public int testHeapByteBufferReadInteger()
	{
		final ByteBuffer t = ByteBufferTest.HEAP;

		t.clear();

		int x = 0;

		while (t.hasRemaining())
		{
			x += t.getInt();
		}

		return x;
	}

	@Benchmark
	public byte testArrayMixed()
	{
		final byte[] t = ByteBufferTest.HEAP.array();

		byte x = 0;

		for (int i = 0; i < ByteBufferTest.LIMIT;)
		{
			x += t[i++];

			t[i++] = x;
		}

		return x;
	}

	@Benchmark
	public byte testUnsafeMixed()
	{
		final Unsafe u = ByteBufferTest.UNSAFE;

		final long t = ByteBufferTest.NATIVE;

		byte x = 0;

		for (int i = 0; i < ByteBufferTest.LIMIT;)
		{
			x += u.getByte(t + i++);

			u.putByte(t + i++, x);
		}

		return x;
	}

	@Benchmark
	public byte testDirectByteBufferMixed()
	{
		final ByteBuffer t = ByteBufferTest.DIRECT;

		t.clear();

		byte x = 0;

		while (t.hasRemaining())
		{
			x += t.get();

			t.put(x);
		}

		return x;
	}

	@Benchmark
	public byte testHeapByteBufferMixed()
	{
		final ByteBuffer t = ByteBufferTest.HEAP;

		t.clear();

		byte x = 0;

		while (t.hasRemaining())
		{
			x += t.get();

			t.put(x);
		}

		return x;
	}

}
