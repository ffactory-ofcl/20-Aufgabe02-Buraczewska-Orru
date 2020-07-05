# What is a Queue?
A queue is a list-like datastructure that allows to achieve the behavior of a real-world queue.
That is, it adds incoming elements to the back and takes new ones from the front.
> This is called the FIFO - first in, first out - principle.

Applications are vast and vary greatly. In any place where a fair processing order of elements is desired, a queue can be helpful. For example in the process-scheduler of the operating system. New tasks come in and get added to the end of the queue and whenever the required resources to work on a task get freed, the scheduler selects the first one from the queue. In reality, it's more complicated than that, but the underlying structure is queue-like.

Another usecase would be a waiting list of some sort. The tickets for a particular concert are very sought-after and thus the vendor implements a waiting list to fairly distribute any "new" tickets that might be returned to the people in waiting list. First come, first serve.