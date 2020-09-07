package bench.nio;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Tests practical cost of allocating Direct and Heap ByteBuffers.
 */
public class ByteBufferAllocationTest
{
	@Benchmark
	public void test512DirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(512));
		}

		l.clear();
	}

	@Benchmark
	public void test512HeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(512));
		}

		l.clear();
	}

	@Benchmark
	public void test2KDirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(1024 * 2));
		}

		l.clear();
	}

	@Benchmark
	public void test2KHeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(1024 * 2));
		}

		l.clear();
	}

	@Benchmark
	public void test4KDirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(1024 * 4));
		}

		l.clear();
	}

	@Benchmark
	public void test4KHeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(1024 * 4));
		}

		l.clear();
	}

	@Benchmark
	public void test8KDirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(1024 * 8));
		}

		l.clear();
	}

	@Benchmark
	public void test8KHeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(1024 * 8));
		}

		l.clear();
	}

	@Benchmark
	public void test16KDirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(1024 * 16));
		}

		l.clear();
	}

	@Benchmark
	public void test16KHeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(1024 * 16));
		}

		l.clear();
	}

	@Benchmark
	public void test32KDirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(1024 * 32));
		}

		l.clear();
	}

	@Benchmark
	public void test32KHeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(1024 * 32));
		}

		l.clear();
	}

	@Benchmark
	public void test64KDirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(1024 * 64));
		}

		l.clear();
	}

	@Benchmark
	public void test64KHeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(1024 * 64));
		}

		l.clear();
	}

	@Benchmark
	public void test128KDirectByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocateDirect(1024 * 128));
		}

		l.clear();
	}

	@Benchmark
	public void test128KHeapByteBufferAllocation()
	{
		final ArrayList<Object> l = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			l.add(ByteBuffer.allocate(1024 * 128));
		}

		l.clear();
	}

}
