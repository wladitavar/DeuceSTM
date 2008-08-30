/*
 * @(#)Context.java   05/01/2008
 *
 * Copyright 2008 GigaSpaces Technologies Inc.
 */

package org.deuce.transaction;

import org.deuce.objectweb.asm.Type;
import org.deuce.reflection.AddressUtil;
import org.deuce.transaction.tl2.Context;
import org.deuce.transform.Exclude;

/**
 * All the STM implementations should extend this class.
 * Using the -Dorg.deuce.transaction.contextClass property one can
 * switch between the different implementations. 
 *
 * @author	Guy Korland
 * @since	1.0
 */
@Exclude
abstract public class AbstractContext
{
	final static private int BYTE_ARR_BASE = AddressUtil.arrayBaseOffset(byte[].class);
	final static private int CHAR_ARR_BASE = AddressUtil.arrayBaseOffset(char[].class);
	final static private int SHORT_ARR_BASE = AddressUtil.arrayBaseOffset(short[].class);
	final static private int INT_ARR_BASE = AddressUtil.arrayBaseOffset(int[].class);
	final static private int LONG_ARR_BASE = AddressUtil.arrayBaseOffset(long[].class);
	final static private int FLOAT_ARR_BASE = AddressUtil.arrayBaseOffset(float[].class);
	final static private int DOUBLE_ARR_BASE = AddressUtil.arrayBaseOffset(double[].class);
	final static private int OBJECT_ARR_BASE = AddressUtil.arrayBaseOffset(Object[].class);
	
	final static private int BYTE_ARR_SCALE = AddressUtil.arrayIndexScale(byte[].class);
	final static private int CHAR_ARR_SCALE = AddressUtil.arrayIndexScale(char[].class);
	final static private int SHORT_ARR_SCALE = AddressUtil.arrayIndexScale(short[].class);
	final static private int INT_ARR_SCALE = AddressUtil.arrayIndexScale(int[].class);
	final static private int LONG_ARR_SCALE = AddressUtil.arrayIndexScale(long[].class);
	final static private int FLOAT_ARR_SCALE = AddressUtil.arrayIndexScale(float[].class);
	final static private int DOUBLE_ARR_SCALE = AddressUtil.arrayIndexScale(double[].class);
	final static private int OBJECT_ARR_SCALE = AddressUtil.arrayIndexScale(Object[].class);
	
	final static public Type ABSTRACT_CONTEXT_TYPE = Type.getType( AbstractContext.class);
	final static public String ABSTRACT_CONTEXT_NAME = ABSTRACT_CONTEXT_TYPE.getInternalName();
	final static public String ABSTRACT_CONTEXT_DESC = ABSTRACT_CONTEXT_TYPE.getDescriptor();
	final static public String WRITE_METHOD_NAME = "addWriteAccess";
	final static public String WRITE_ARR_METHOD_NAME = "addArrayWriteAccess";
	final static public String STATIC_WRITE_METHOD_NAME = "addStaticWriteAccess";
	final static public String READ_METHOD_NAME = "addReadAccess";
	final static public String READ_ARR_METHOD_NAME = "addArrayReadAccess";

	final static private String WRITE_METHOD_BOOLEAN_DESC = "(Ljava/lang/Object;ZJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_BYTE_DESC = "(Ljava/lang/Object;BJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_CHAR_DESC = "(Ljava/lang/Object;CJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_SHORT_DESC = "(Ljava/lang/Object;SJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_INT_DESC = "(Ljava/lang/Object;IJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_LONG_DESC = "(Ljava/lang/Object;JJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_FLOAT_DESC = "(Ljava/lang/Object;FJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_DOUBLE_DESC = "(Ljava/lang/Object;DJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String WRITE_METHOD_OBJ_DESC = "(Ljava/lang/Object;Ljava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";

	final static private String STATIC_WRITE_METHOD_BOOLEAN_DESC = "(ZLjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_BYTE_DESC = "(BLjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_CHAR_DESC = "(CLjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_SHORT_DESC = "(SLjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_INT_DESC = "(ILjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_LONG_DESC = "(JLjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_FLOAT_DESC = "(FLjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_DOUBLE_DESC = "(DLjava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";
	final static private String STATIC_WRITE_METHOD_OBJ_DESC = "(Ljava/lang/Object;Ljava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")V";

	final static private String READ_METHOD_BOOLEAN_DESC = "(Ljava/lang/Object;ZJ" + ABSTRACT_CONTEXT_DESC +")Z";
	final static private String READ_METHOD_BYTE_DESC = "(Ljava/lang/Object;BJ" + ABSTRACT_CONTEXT_DESC +")B";
	final static private String READ_METHOD_CHAR_DESC = "(Ljava/lang/Object;CJ" + ABSTRACT_CONTEXT_DESC +")C";
	final static private String READ_METHOD_SHORT_DESC = "(Ljava/lang/Object;SJ" + ABSTRACT_CONTEXT_DESC +")S";
	final static private String READ_METHOD_INT_DESC = "(Ljava/lang/Object;IJ" + ABSTRACT_CONTEXT_DESC +")I";
	final static private String READ_METHOD_LONG_DESC = "(Ljava/lang/Object;JJ" + ABSTRACT_CONTEXT_DESC +")J";
	final static private String READ_METHOD_FLOAT_DESC = "(Ljava/lang/Object;FJ" + ABSTRACT_CONTEXT_DESC +")F";
	final static private String READ_METHOD_DOUBLE_DESC = "(Ljava/lang/Object;DJ" + ABSTRACT_CONTEXT_DESC +")D";
	final static private String READ_METHOD_OBJ_DESC = "(Ljava/lang/Object;Ljava/lang/Object;J" + ABSTRACT_CONTEXT_DESC +")Ljava/lang/Object;";

	final static public String WRITE_ARRAY_METHOD_BYTE_DESC = "([BIB" + ABSTRACT_CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_CHAR_DESC = "([CIC" + ABSTRACT_CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_SHORT_DESC = "([SIS" + ABSTRACT_CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_INT_DESC = "([III" + ABSTRACT_CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_LONG_DESC = "([JIJ" + ABSTRACT_CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_FLOAT_DESC = "([FIF" + ABSTRACT_CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_DOUBLE_DESC = "([DID" + ABSTRACT_CONTEXT_DESC +")V";
	final static public String WRITE_ARRAY_METHOD_OBJ_DESC = "([Ljava/lang/Object;ILjava/lang/Object;" + ABSTRACT_CONTEXT_DESC +")V";

	final static public String READ_ARRAY_METHOD_BYTE_DESC = "([BI" + ABSTRACT_CONTEXT_DESC +")B";
	final static public String READ_ARRAY_METHOD_CHAR_DESC = "([CI" + ABSTRACT_CONTEXT_DESC +")C";
	final static public String READ_ARRAY_METHOD_SHORT_DESC = "([SI" + ABSTRACT_CONTEXT_DESC +")S";
	final static public String READ_ARRAY_METHOD_INT_DESC = "([II" + ABSTRACT_CONTEXT_DESC +")I";
	final static public String READ_ARRAY_METHOD_LONG_DESC = "([JI" + ABSTRACT_CONTEXT_DESC +")J";
	final static public String READ_ARRAY_METHOD_FLOAT_DESC = "([FI" + ABSTRACT_CONTEXT_DESC +")F";
	final static public String READ_ARRAY_METHOD_DOUBLE_DESC = "([DI" + ABSTRACT_CONTEXT_DESC +")D";
	final static public String READ_ARRAY_METHOD_OBJ_DESC = "([Ljava/lang/Object;I" + ABSTRACT_CONTEXT_DESC +")Ljava/lang/Object;";
	
	final private static ContextThreadLocal THREAD_CONTEXT = new ContextThreadLocal();

	@Exclude
	private static class ContextThreadLocal extends ThreadLocal<AbstractContext>
	{
		private Class<?> contextClass;  

		public ContextThreadLocal(){
			String className = System.getProperty( "org.deuce.transaction.contextClass");
			if( className != null){
				try {
					this.contextClass = Class.forName(className);
					return;
				} catch (ClassNotFoundException e) {
					e.printStackTrace(); // TODO add logger
				}
			}
			this.contextClass = Context.class;
		}

		@Override
		protected synchronized AbstractContext initialValue() {
			try {
				return (AbstractContext)this.contextClass.newInstance();
			} catch (Exception e) {
				throw new TransactionException( e);
			}
		}
	}

	public static AbstractContext getInstance(){
		AbstractContext context = THREAD_CONTEXT.get();
		context.init();
		return context;
	}

	public static String getWriteMethodDesc( String desc) {
		Type type = Type.getType(desc);
		switch( type.getSort()) {
		case Type.BOOLEAN:
			return WRITE_METHOD_BOOLEAN_DESC;
		case Type.BYTE:
			return WRITE_METHOD_BYTE_DESC;
		case Type.CHAR:
			return WRITE_METHOD_CHAR_DESC;
		case Type.SHORT:
			return WRITE_METHOD_SHORT_DESC;
		case Type.INT:
			return WRITE_METHOD_INT_DESC;
		case Type.LONG:
			return WRITE_METHOD_LONG_DESC;
		case Type.FLOAT:
			return WRITE_METHOD_FLOAT_DESC;
		case Type.DOUBLE:
			return WRITE_METHOD_DOUBLE_DESC;
		default:
			return WRITE_METHOD_OBJ_DESC;
		}
	}

	public static String getStaticWriteMethodDesc( String desc) {
		Type type = Type.getType(desc);
		switch( type.getSort()) {
		case Type.BOOLEAN:
			return STATIC_WRITE_METHOD_BOOLEAN_DESC;
		case Type.BYTE:
			return STATIC_WRITE_METHOD_BYTE_DESC;
		case Type.CHAR:
			return STATIC_WRITE_METHOD_CHAR_DESC;
		case Type.SHORT:
			return STATIC_WRITE_METHOD_SHORT_DESC;
		case Type.INT:
			return STATIC_WRITE_METHOD_INT_DESC;
		case Type.LONG:
			return STATIC_WRITE_METHOD_LONG_DESC;
		case Type.FLOAT:
			return STATIC_WRITE_METHOD_FLOAT_DESC;
		case Type.DOUBLE:
			return STATIC_WRITE_METHOD_DOUBLE_DESC;
		default:
			return STATIC_WRITE_METHOD_OBJ_DESC;
		}
	}

	public static String getReadMethodDesc( String desc) {
		Type type = Type.getType(desc);
		switch( type.getSort()) {
		case Type.BOOLEAN:
			return READ_METHOD_BOOLEAN_DESC;
		case Type.BYTE:
			return READ_METHOD_BYTE_DESC;
		case Type.CHAR:
			return READ_METHOD_CHAR_DESC;
		case Type.SHORT:
			return READ_METHOD_SHORT_DESC;
		case Type.INT:
			return READ_METHOD_INT_DESC;
		case Type.LONG:
			return READ_METHOD_LONG_DESC;
		case Type.FLOAT:
			return READ_METHOD_FLOAT_DESC;
		case Type.DOUBLE:
			return READ_METHOD_DOUBLE_DESC;
		default:
			return READ_METHOD_OBJ_DESC;
		}
	}

	/**
	 * Called before the transaction was started
	 */
	abstract protected void init();

	/**
	 * Called on commit
	 * @return <code>true</code> on success 
	 */
	abstract public boolean commit();

	/**
	 * Called on rollback, rollback might be called more than once in a row.
	 * But, can't be called after {@link #commit()} without an {@link #init()} call in between. 
	 */
	abstract public void rollback();

	static public <T> T addReadAccess( Object obj, T value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public boolean addReadAccess( Object obj, boolean value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public byte addReadAccess( Object obj, byte value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public char addReadAccess( Object obj, char value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public short addReadAccess( Object obj, short value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public int addReadAccess( Object obj, int value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public long addReadAccess( Object obj, long value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public float addReadAccess( Object obj, float value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}
	static public double addReadAccess( Object obj, double value, long field, AbstractContext context) {
		return context.addReadAccess(obj, value, field);
	}

	static public void addWriteAccess( Object obj, Object value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, boolean value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, byte value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, char value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, short value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, int value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, long value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, float value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}
	static public void addWriteAccess( Object obj, double value, long field, AbstractContext context) {
		context.addWriteAccess(obj, value, field);
	}

	static public void addStaticWriteAccess( Object value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( boolean value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( byte value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( char value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( short value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( int value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( long value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( float value, Object obj, long field, AbstractContext context) {
		context.addStaticWriteAccess(value, obj, field);
	}
	static public void addStaticWriteAccess( double value, Object obj, long field, AbstractContext context) { 
		context.addStaticWriteAccess(value, obj, field);
	}
	
	static public <T> T addArrayReadAccess( T[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], OBJECT_ARR_BASE + OBJECT_ARR_SCALE*index);
	}
	static public byte addArrayReadAccess( byte[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], BYTE_ARR_BASE + BYTE_ARR_SCALE*index);
	}
	static public char addArrayReadAccess( char[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], CHAR_ARR_BASE + CHAR_ARR_SCALE*index);
	}
	static public short addArrayReadAccess( short[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], SHORT_ARR_BASE + SHORT_ARR_SCALE*index);
	}
	static public int addArrayReadAccess( int[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], INT_ARR_BASE + INT_ARR_SCALE*index);
	}
	static public long addArrayReadAccess( long[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], LONG_ARR_BASE + LONG_ARR_SCALE*index);
	}
	static public float addArrayReadAccess( float[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], FLOAT_ARR_BASE + FLOAT_ARR_SCALE*index);
	}
	static public double addArrayReadAccess( double[] arr, int index, AbstractContext context) {
		return context.addReadAccess(arr, arr[index], DOUBLE_ARR_BASE + DOUBLE_ARR_SCALE*index);
	}

	static public <T> void addArrayWriteAccess( T[] arr,  int index, T value, AbstractContext context) {
		context.addWriteAccess(arr, value, OBJECT_ARR_BASE + OBJECT_ARR_SCALE*index);
	}
	static public void addArrayWriteAccess( byte[] arr, int index, byte value, AbstractContext context) {
		context.addWriteAccess(arr, value, BYTE_ARR_BASE + BYTE_ARR_SCALE*index);
	}
	static public void addArrayWriteAccess( char[] arr, int index, char value, AbstractContext context) {
		context.addWriteAccess(arr, value, CHAR_ARR_BASE + CHAR_ARR_SCALE*index);
	}
	static public void addArrayWriteAccess( short[] arr, int index, short value, AbstractContext context) {
		context.addWriteAccess(arr, value, SHORT_ARR_BASE + SHORT_ARR_SCALE*index);
	}
	static public void addArrayWriteAccess( int[] arr, int index, int value, AbstractContext context) {
		context.addWriteAccess(arr, value, INT_ARR_BASE + INT_ARR_SCALE*index);
	}
	static public void addArrayWriteAccess( long[] arr, int index, long value, AbstractContext context) {
		context.addWriteAccess(arr, value, LONG_ARR_BASE + LONG_ARR_SCALE*index);
	}
	static public void addArrayWriteAccess( float[] arr, int index, float value, AbstractContext context) {
		context.addWriteAccess(arr, value, FLOAT_ARR_BASE + FLOAT_ARR_SCALE*index);
	}
	static public void addArrayWriteAccess( double[] arr, int index, double value, AbstractContext context) {
		context.addWriteAccess(arr, value, DOUBLE_ARR_BASE + DOUBLE_ARR_SCALE*index);
	}

	abstract protected <T> T addReadAccess( Object obj, T value, long field);
	abstract protected boolean addReadAccess( Object obj, boolean value, long field);
	abstract protected byte addReadAccess( Object obj, byte value, long field);
	abstract protected char addReadAccess( Object obj, char value, long field);
	abstract protected short addReadAccess( Object obj, short value, long field);
	abstract protected int addReadAccess( Object obj, int value, long field);
	abstract protected long addReadAccess( Object obj, long value, long field);
	abstract protected float addReadAccess( Object obj, float value, long field);
	abstract protected double addReadAccess( Object obj, double value, long field);

	abstract protected void addWriteAccess( Object obj, Object value, long field);
	abstract protected void addWriteAccess( Object obj, boolean value, long field);
	abstract protected void addWriteAccess( Object obj, byte value, long field);
	abstract protected void addWriteAccess( Object obj, char value, long field);
	abstract protected void addWriteAccess( Object obj, short value, long field);
	abstract protected void addWriteAccess( Object obj, int value, long field);
	abstract protected void addWriteAccess( Object obj, long value, long field);
	abstract protected void addWriteAccess( Object obj, float value, long field);
	abstract protected void addWriteAccess( Object obj, double value, long field);

	abstract protected void addStaticWriteAccess( Object value, Object obj, long field);
	abstract protected void addStaticWriteAccess( boolean value, Object obj, long field);
	abstract protected void addStaticWriteAccess( byte value, Object obj, long field);
	abstract protected void addStaticWriteAccess( char value, Object obj, long field);
	abstract protected void addStaticWriteAccess( short value, Object obj, long field);
	abstract protected void addStaticWriteAccess( int value, Object obj, long field);
	abstract protected void addStaticWriteAccess( long value, Object obj, long field);
	abstract protected void addStaticWriteAccess( float value, Object obj, long field);
	abstract protected void addStaticWriteAccess( double value, Object obj, long field);
}
