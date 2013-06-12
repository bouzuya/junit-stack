package net.bouzuya.junit;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class StackTest {
	public static class IsEmpty {
		@Rule
		public ExpectedException ex = ExpectedException.none();

		private Stack<Integer> sut;

		@Before
		public void setUp() {
			sut = new StackImpl<Integer>();
		}

		@Test
		public void popThrowIllegalStateException() {
			ex.expect(IllegalStateException.class);
			sut.pop();
		}
	}

	public static class HasOneElement {
		private Stack<Integer> sut;

		@Before
		public void setUp() {
			sut = new StackImpl<Integer>();
			sut.push(Integer.valueOf(10));
		}

		@Test
		public void popReturn10() {
			Integer actual = sut.pop();
			Integer expected = Integer.valueOf(10);
			assertThat(actual, is(expected));
		}
	}

	public static class HasTwoElement {
		private Stack<Integer> sut;

		@Before
		public void setUp() {
			sut = new StackImpl<Integer>();
			sut.push(Integer.valueOf(10));
			sut.push(Integer.valueOf(20));
		}

		@Test
		public void popReturn20And10() {
			Integer actual1 = sut.pop();
			Integer expected1 = Integer.valueOf(20);
			Integer actual2 = sut.pop();
			Integer expected2 = Integer.valueOf(10);
			assertThat(actual1, is(expected1));
			assertThat(actual2, is(expected2));
		}
	}
}
