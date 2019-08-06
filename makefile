# define a makefile variable for the java compiler
#
JCC = javac
ARGS = @javac_args

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: .class

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
.class: Fault_Tolerance.java
	$(JCC) $(ARGS) Fault_Tolerance.java

run: 
	java -cp ./build: Fault_Tolerance

all: clean default run
# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	$(RM) -rf ./build/*