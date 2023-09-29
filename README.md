# ListsHW
Jorge Patino
jmp17450@uga.edu


    to run and compile use : "./complile.sh" command
for the merge function I tried to make the compelxity O(n) since I wouls just need to find where the lists had duplicates and exclude those from being inserted.
    while (mainListPos != null)
    if (mainItem.compareTo(newItem) == 0 (equal)){
    then skip
    mainlistPos = mainlistPos.next
    }
    else
    insert(newItem);


for the intersection I wanted to do the opposite but with two while loops to go through each element in the original list compared to the new list.
    and create a new list with all the intersectig values;
while(mainlistPos != null) {
    while (newlistpos != null) {
    if (mainItem.compareTo(newItem) == 0) {
    thirdList.insertItem(mainItem);
        }
    else {
    newListPos = pos.next;
    }
    }
    mainlistPos = mainlistPos.next
    }
