package com.muldis.data_engine_reference.test.client;

import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap.SimpleImmutableEntry;

public final class MUSE_Machine
{
    public final MUSE_Factory MUSE_Factory;

    Object server_machine;

    MUSE_Machine(final MUSE_Factory factory, final Object server_machine)
    {
        this.MUSE_Factory   = factory;
        this.server_machine = server_machine;
    }

    public void provides_Muldis_Service_Protocol_Machine() {}

    public MUSE_Value MUSE_evaluate(final MUSE_Value function)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (function == null)
        {
            throw new IllegalArgumentException("Argument \"function\" must not be null.");
        }
        return new MUSE_Value(this, this.server_machine.getClass()
            .getMethod("MUSE_evaluate", Object.class)
            .invoke(this.server_machine, function.server_value));
    }

    public MUSE_Value MUSE_evaluate(final MUSE_Value function, final MUSE_Value args)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (function == null)
        {
            throw new IllegalArgumentException("Argument \"function\" must not be null.");
        }
        return new MUSE_Value(this, this.server_machine.getClass()
            .getMethod("MUSE_evaluate", Object.class, Object.class)
            .invoke(this.server_machine, function.server_value, args.server_value));
    }

    public void MUSE_perform(final MUSE_Value procedure)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (procedure == null)
        {
            throw new IllegalArgumentException("Argument \"procedure\" must not be null.");
        }
        this.server_machine.getClass()
            .getMethod("MUSE_perform", Object.class)
            .invoke(this.server_machine, procedure.server_value);
    }

    public void MUSE_perform(final MUSE_Value procedure, final MUSE_Value args)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (procedure == null)
        {
            throw new IllegalArgumentException("Argument \"procedure\" must not be null.");
        }
        if (args == null)
        {
            throw new IllegalArgumentException("Argument \"args\" must not be null.");
        }
        this.server_machine.getClass()
            .getMethod("MUSE_perform", Object.class, Object.class)
            .invoke(this.server_machine, procedure.server_value, args.server_value);
    }

    public MUSE_Value MUSE_current(final MUSE_Value variable)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (variable == null)
        {
            throw new IllegalArgumentException("Argument \"variable\" must not be null.");
        }
        return new MUSE_Value(this, this.server_machine.getClass()
            .getMethod("MUSE_current", Object.class)
            .invoke(this.server_machine, variable.server_value));
    }

    public void MUSE_assign(final MUSE_Value variable, final MUSE_Value new_current)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (variable == null)
        {
            throw new IllegalArgumentException("Argument \"variable\" must not be null.");
        }
        if (new_current == null)
        {
            throw new IllegalArgumentException("Argument \"new_current\" must not be null.");
        }
        this.server_machine.getClass()
            .getMethod("MUSE_assign", Object.class, Object.class)
            .invoke(this.server_machine, variable.server_value, new_current.server_value);
    }

    public MUSE_Value MUSE_import(final Object value)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        return new MUSE_Value(this, this.server_machine.getClass()
            .getMethod("MUSE_import", Object.class)
            .invoke(this.server_machine, value));
    }

    public MUSE_Value MUSE_import_qualified(final SimpleImmutableEntry<String, Object> value)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (value == null)
        {
            throw new IllegalArgumentException("Argument \"value\" must not be null.");
        }
        return new MUSE_Value(this, this.server_machine.getClass()
            .getMethod("MUSE_import_qualified", SimpleImmutableEntry.class)
            .invoke(this.server_machine, value));
    }

    public Object MUSE_export(final MUSE_Value value)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (value == null)
        {
            throw new IllegalArgumentException("Argument \"value\" must not be null.");
        }
        return this.server_machine.getClass()
            .getMethod("MUSE_export", Object.class)
            .invoke(this.server_machine, value.server_value);
    }

    public SimpleImmutableEntry<String, Object> MUSE_export_qualified(final MUSE_Value value)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        if (value == null)
        {
            throw new IllegalArgumentException("Argument \"value\" must not be null.");
        }
        return (SimpleImmutableEntry<String, Object>)this.server_machine.getClass()
            .getMethod("MUSE_export_qualified", Object.class)
            .invoke(this.server_machine, value.server_value);
    }
}
