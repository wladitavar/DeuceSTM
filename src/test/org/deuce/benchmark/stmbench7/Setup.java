package org.deuce.benchmark.stmbench7;

import org.deuce.benchmark.stmbench7.annotations.Immutable;
import org.deuce.benchmark.stmbench7.backend.BackendFactory;
import org.deuce.benchmark.stmbench7.backend.Index;
import org.deuce.benchmark.stmbench7.backend.LargeSet;
import org.deuce.benchmark.stmbench7.core.AssemblyBuilder;
import org.deuce.benchmark.stmbench7.core.AtomicPart;
import org.deuce.benchmark.stmbench7.core.BaseAssembly;
import org.deuce.benchmark.stmbench7.core.ComplexAssembly;
import org.deuce.benchmark.stmbench7.core.CompositePart;
import org.deuce.benchmark.stmbench7.core.CompositePartBuilder;
import org.deuce.benchmark.stmbench7.core.Document;
import org.deuce.benchmark.stmbench7.core.Module;
import org.deuce.benchmark.stmbench7.core.ModuleBuilder;
import org.deuce.benchmark.stmbench7.operations.SetupDataStructure;

/**
 * Sets up the benchmark structures according to given parameters,
 * including indexes.
 */
@Immutable
public class Setup {
    
    protected Module module;

    protected Index<Integer,AtomicPart> atomicPartIdIndex;
    protected Index<Integer,LargeSet<AtomicPart>> atomicPartBuildDateIndex;
    protected Index<String,Document> documentTitleIndex;
    protected Index<Integer,CompositePart> compositePartIdIndex;
    protected Index<Integer,BaseAssembly> baseAssemblyIdIndex;
    protected Index<Integer,ComplexAssembly> complexAssemblyIdIndex;

    protected CompositePartBuilder compositePartBuilder;
    protected ModuleBuilder moduleBuilder;
    
    public Setup() throws InterruptedException {
    	BackendFactory backendFactory = BackendFactory.instance;
    	
    	atomicPartIdIndex = backendFactory.<Integer,AtomicPart>createIndex();
    	atomicPartBuildDateIndex = backendFactory.<Integer,LargeSet<AtomicPart>>createIndex();
    	documentTitleIndex = backendFactory.<String,Document>createIndex();
    	compositePartIdIndex = backendFactory.<Integer,CompositePart>createIndex();
    	baseAssemblyIdIndex = backendFactory.<Integer,BaseAssembly>createIndex();
    	complexAssemblyIdIndex = backendFactory.<Integer,ComplexAssembly>createIndex();    	

    	compositePartBuilder = new CompositePartBuilder(compositePartIdIndex,
    			documentTitleIndex,	atomicPartIdIndex, atomicPartBuildDateIndex);
    	moduleBuilder = new ModuleBuilder(baseAssemblyIdIndex, complexAssemblyIdIndex);
    	
    	SetupDataStructure setupOperation = new SetupDataStructure(this);
    	OperationExecutorFactory.executeSequentialOperation(setupOperation);
    	module = setupOperation.getModule();
    }
    
	public Index<Integer, LargeSet<AtomicPart>> getAtomicPartBuildDateIndex() {
		return atomicPartBuildDateIndex;
	}

	public Index<Integer, AtomicPart> getAtomicPartIdIndex() {
		return atomicPartIdIndex;
	}

	public Index<Integer, BaseAssembly> getBaseAssemblyIdIndex() {
		return baseAssemblyIdIndex;
	}

	public Index<Integer, ComplexAssembly> getComplexAssemblyIdIndex() {
		return complexAssemblyIdIndex;
	}

	public Index<Integer, CompositePart> getCompositePartIdIndex() {
		return compositePartIdIndex;
	}

	public Index<String, Document> getDocumentTitleIndex() {
		return documentTitleIndex;
	}

	public Module getModule() {
		return module;
	}
	
	public CompositePartBuilder getCompositePartBuilder() {
		return compositePartBuilder;
	}
	
	public ModuleBuilder getModuleBuilder() {
		return moduleBuilder;
	}
	
	public AssemblyBuilder getAssemblyBuilder() {
		return moduleBuilder.getAssemblyBuilder();
	}
}
