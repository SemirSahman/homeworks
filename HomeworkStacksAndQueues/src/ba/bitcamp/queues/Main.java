package ba.bitcamp.queues;

public class Main {

	public static void main(String[] args) {


		QueueDoubleArray qda = new QueueDoubleArray();

		qda.add(1.3);
		qda.offer(1.2);
		System.out.println(qda);
		System.out.println(qda.peek());
		System.out.println(qda.remove());
		System.out.println(qda);

		Long startArray = System.currentTimeMillis();
		for (int i = 1; i < 100000; i++) {

			qda.add(i + 1.0);

		}

		System.out.println("Array processing time: "
				+ (System.currentTimeMillis() - startArray));

		System.out.println();

		
		QueueDoubleLink qdl = new QueueDoubleLink();
		
		qdl.add(1.3);
		qdl.add(1.1);
		qdl.add(5.5);
		System.out.println(qdl);
		
		System.out.println(qdl.peek());
		System.out.println(qdl.poll());
		System.out.println(qdl);
		
		Long startLink = System.currentTimeMillis();

		for (int i = 1; i < 100000; i++) {
			qdl.add( i + 2.0);
		}

		System.out.println("Link processing time: "+ (System.currentTimeMillis() - startLink));


	}

}