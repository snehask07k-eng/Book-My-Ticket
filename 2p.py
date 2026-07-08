# creat a list 
my_list=[10,20,30,40]
print("Original list:", my_list)

# Append an element
my_list.append(50)
print("After Appending 50:",my_list)

# Inserting an element 
my_list.insert(2,25)
print("After Inserting 25 at index 2:",my_list)

# Remove an element
my_list.remove(30)
print("After Removing 30 :",my_list)

# Display length 
print("Current Length of list:",len(my_list))

# Pop an element 
popped_val = my_list.pop()
print("Popped element:",popped_val)
print("After Popping last element:",my_list)

