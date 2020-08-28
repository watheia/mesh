package com.gentics.mesh.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class StreamUtil {
	private StreamUtil() {

	}

	public static <T> Stream<T> toStream(Iterable<? extends T> iterable) {
		return (Stream<T>)StreamSupport.stream(iterable.spliterator(), false);
	}

	public static <T> Stream<T> toStream(Iterator<? extends T> iterator) {
		return toStream(() -> (Iterator<T>)iterator);
	}

	/**
	 * Turns an optional into a stream.
	 *
	 * @deprecated Use {@link Optional#stream()} instead
	 * @param opt
	 * @param <T>
	 * @return
	 */
	@Deprecated
	public static <T> Stream<T> toStream(Optional<T> opt) {
		return opt.map(Stream::of).orElseGet(Stream::empty);
	}

	/**
	 * Applies the {@code nextValue} operator repeatedly to its previous result until null is returned.
	 *
	 * @param initialValue
	 * @param nextValue
	 * @param <T>
	 * @return
	 */
	public static <T> Stream<T> untilNull(Supplier<T> initialValue, UnaryOperator<T> nextValue) {
		return toStream(new Iterator<T>() {
			Supplier<T> next = lazy(initialValue);

			@Override
			public boolean hasNext() {
				return next.get() != null;
			}

			@Override
			public T next() {
				T returnedValue = next.get();
				next = lazy(() -> nextValue.apply(returnedValue));
				return returnedValue;
			}
		});
	}

	public static <T> Supplier<T> lazy(Supplier<T> supplier) {
		return new Supplier<T>() {
			T value;
			boolean hasBeenCalled;

			@Override
			public T get() {
				if (!hasBeenCalled) {
					hasBeenCalled = true;
					value = supplier.get();
				}
				return value;
			}
		};
	}

	public static <K, V> Collector<Map<K, V>, Map<K, V>, Map<K, V>> mergeMaps() {
		return Collector.of(
			HashMap::new,
			Map::putAll,
			(m1, m2) -> {
				m1.putAll(m2);
				return m1;
			}
		);
	}

	public static <T> Stream<T> ofNullable(T... elements) {
		return Arrays.stream(elements)
			.filter(Objects::nonNull);
	}

	public static <T> Predicate<T> not(Predicate<T> predicate) {
		return predicate.negate();
	}

	/**
	 * Filters out duplicate items in the stream. Use this with {@link Stream#filter(Predicate)}.
	 * @return
	 */
	public static <T> Predicate<T> unique() {
		return uniqueBy(Function.identity());
	}

	/**
	 * Filters out duplicate items in the stream. Use this with {@link Stream#filter(Predicate)}.
	 * Two items are considered equal when the results of the <code>keyMapper</code> function are equal by {@link #equals(Object)}.
	 * @param keyMapper
	 * @param <T>
	 * @param <K>
	 * @return
	 */
	public static <T, K> Predicate<T> uniqueBy(Function<T, K> keyMapper) {
		Set<K> keys = new HashSet<>();
		return item -> {
			K key = keyMapper.apply(item);
			if (keys.contains(key)) {
				return false;
			} else {
				keys.add(key);
				return true;
			}
		};
	}

	/**
	 * Creates a stream that provides the elements of an array in reverse order.
	 *
	 * @param arr
	 * @param <T>
	 * @return
	 */
	public static <T> Stream<T> reverseOf(T[] arr) {
		return IntStream.iterate(arr.length - 1, i -> i - 1)
			.limit(arr.length)
			.mapToObj(i -> arr[i]);
	}
}
