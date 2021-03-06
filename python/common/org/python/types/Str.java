package org.python.types;

public class Str extends org.python.types.Object {
    public java.lang.String value;

    /**
     * A utility method to update the internal value of this object.
     *
     * Used by __i*__ operations to do an in-place operation.
     * obj must be of type org.python.types.Str
     */
    void setValue(org.python.Object obj) {
        this.value = ((org.python.types.Str) obj).value;
    }

    public java.lang.Object toJava() {
        return this.value;
    }

    public org.python.Object byValue() {
        return new org.python.types.Str(this.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public Str(java.lang.String str) {
        this.value = str;
    }

    public Str(char chr) {
        this.value = new java.lang.String(new char [] {chr});
    }

    // public org.python.Object __new__() {
    //     throw new org.python.exceptions.NotImplementedError("__new__() has not been implemented.");
    // }

    // public org.python.Object __init__() {
    //     throw new org.python.exceptions.NotImplementedError("__init__() has not been implemented.");
    // }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __repr__() {
        return new org.python.types.Str("'" + this.value + "'");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __str__() {
        return new org.python.types.Str(this.value);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __format__(org.python.Object format_string) {
        throw new org.python.exceptions.NotImplementedError("__format__() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Int __int__() {
        try {
            return new org.python.types.Int(Long.parseLong(this.value));
        } catch (NumberFormatException e) {
            throw new org.python.exceptions.ValueError("invalid literal for int() with base 10: '" + this.value + "'");
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Float __float__() {
        double result;
        try {
            result = Double.parseDouble(this.value);
        } catch (NumberFormatException e) {
            String trimmed = this.value.trim();
            if (trimmed == "inf") {
                result = Double.POSITIVE_INFINITY;
            } else if (trimmed == "-inf") {
                result = Double.NEGATIVE_INFINITY;
            } else if (trimmed == "nan") {
                result = Double.NaN;
            } else {
                String value = this.value;
                if (value.length() > 0) {
                    value = "'" + value + "'";
                }
                throw new org.python.exceptions.ValueError(
                    "could not convert string to float: " + value);
            }
        }
        return new org.python.types.Float(result);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __lt__(org.python.Object other) {
        if (other instanceof org.python.types.Str) {
            java.lang.String value = ((org.python.types.Str) other).value;
            return new org.python.types.Bool(this.value.compareTo(value) < 0);
        } else {
            throw new org.python.exceptions.TypeError("unorderable types: " + this.typeName() + "() < " + other.typeName() + "()");
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __le__(org.python.Object other) {
        if (other instanceof org.python.types.Str) {
            java.lang.String value = ((org.python.types.Str) other).value;
            return new org.python.types.Bool(this.value.compareTo(value) <= 0);
        } else {
            throw new org.python.exceptions.TypeError("unorderable types: " + this.typeName() + "() <= " + other.typeName() + "()");
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __eq__(org.python.Object other) {
        if (other instanceof org.python.types.Str) {
            java.lang.String value = ((org.python.types.Str) other).value;
            return new org.python.types.Bool(this.value.equals(value));
        } else {
            return new org.python.types.Bool(false);
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __ne__(org.python.Object other) {
        if (other instanceof org.python.types.Str) {
            java.lang.String value = ((org.python.types.Str) other).value;
            return new org.python.types.Bool(!this.value.equals(value));
        } else {
            return new org.python.types.Bool(true);
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __gt__(org.python.Object other) {
        if (other instanceof org.python.types.Str) {
            java.lang.String value = ((org.python.types.Str) other).value;
            return new org.python.types.Bool(this.value.compareTo(value) > 0);
        } else {
            throw new org.python.exceptions.TypeError("unorderable types: " + this.typeName() + "() > " + other.typeName() + "()");
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __ge__(org.python.Object other) {
        if (other instanceof org.python.types.Str) {
            java.lang.String value = ((org.python.types.Str) other).value;
            return new org.python.types.Bool(this.value.compareTo(value) >= 0);
        } else {
            throw new org.python.exceptions.TypeError("unorderable types: " + this.typeName() + "() >= " + other.typeName() + "()");
        }
    }

    public boolean __setattr_null(java.lang.String name, org.python.Object value) {
        // Builtin types can't have attributes set on them.
        return false;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.List __dir__() {
        throw new org.python.exceptions.NotImplementedError("__dir__() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = "len(object)\n\nReturn the number of items of a sequence or collection."
    )
    public org.python.types.Int __len__() {
	return new org.python.types.Int(this.value.length());
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __getitem__(org.python.Object index) {
        try {
            if (index instanceof org.python.types.Slice) {
                org.python.types.Slice slice = (org.python.types.Slice) index;
                java.lang.String sliced;

                if (slice.start == null && slice.stop == null && slice.step == null) {
                    sliced = this.value;
                }
                else {
                    long start;
                    if (slice.start != null) {
                        start = toPositiveIndex(Math.min(slice.start.value, this.value.length()));
                    } else {
                        start = 0;
                    }

                    long stop;
                    if (slice.stop != null) {
                        stop = toPositiveIndex(Math.min(slice.stop.value, this.value.length()));
                    } else {
                        stop = this.value.length();
                    }

                    long step;
                    if (slice.step != null) {
                        step = slice.step.value;
                    } else {
                        step = 1;
                    }

                    if (step == 1) {
                        sliced = this.value.substring((int) start, (int) stop);
                    } else {
                        java.lang.StringBuffer buffer = new java.lang.StringBuffer();
                        for (long i = start; i < stop; i += step) {
                            buffer.append(this.value.charAt((int)i));
                        }
                        sliced = buffer.toString();
                    }
                }
                return new org.python.types.Str(sliced);
            } else if (index instanceof org.python.types.Bool) {
                boolean slice = ((org.python.types.Bool) index).value;
                java.lang.String sliced;

                if (this.value.length() == 0) {
                    throw new org.python.exceptions.IndexError("string index out of range");
                } else {
                    if (slice) {
                       sliced = this.value.substring(1, 2);
                    }
                    else {
                       sliced = this.value.substring(0, 1);
                    }
                    return new org.python.types.Str(sliced);
                }
            } else {
                int idx = (int)((org.python.types.Int) index).value;
                if (idx < 0) {
                    if (-idx > this.value.length()) {
                        throw new org.python.exceptions.IndexError("string index out of range");
                    } else {
                        return new org.python.types.Str(this.value.charAt(this.value.length() + idx));
                    }
                } else {
                    if (idx >= this.value.length()) {
                        throw new org.python.exceptions.IndexError("string index out of range");
                    } else {
                        return new org.python.types.Str(this.value.charAt(idx));
                    }
                }
            }
        } catch (ClassCastException e) {
            throw new org.python.exceptions.TypeError("string indices must be integers");
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Iterable __iter__() {
        throw new org.python.exceptions.NotImplementedError("__iter__() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Int __contains__(org.python.Object item) {
        if (item instanceof org.python.types.Str){

            int substr_exists = 0;
            org.python.types.Str item_str = (org.python.types.Str)item;

            if (this.value.length() == 0 && item_str.value.length() == 0){
                substr_exists = 1;
            }
            else {
                for(int i = 0; i < this.value.length() - item_str.value.length(); i++){
                    boolean mismatch = false;
                    for(int j = 0; j < item_str.value.length(); j++){
                        if (this.value.charAt(i + j) != item_str.value.charAt(j)){
                            mismatch = true;
                            break;
                        }
                    }
                    if (!mismatch){
                        substr_exists = 1;
                    }
                }
            }
            return new org.python.types.Int(substr_exists);
        }
        throw new org.python.exceptions.TypeError("Can't convert '" + item.typeName() + "' object to str implicitly");
        // throw new org.python.exceptions.NotImplementedError("__contains__() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __add__(org.python.Object other) {
        if (other instanceof org.python.types.Str) {
            org.python.types.Str other_str = (org.python.types.Str)other;
            if (0 == other_str.value.length()) {
                return this;
            }
            java.lang.StringBuffer sb = new java.lang.StringBuffer(value);
            sb.append(other_str.value);
            return new org.python.types.Str(sb.toString());
        }
        throw new org.python.exceptions.TypeError("Can't convert '" + other.typeName() + "' object to str implicitly");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __mul__(org.python.Object other) {
        if (other instanceof org.python.types.Int) {
            long other_int = ((org.python.types.Int)other).value;
            if (other_int < 1) {
                return new Str("");
            }
            java.lang.StringBuffer res = new java.lang.StringBuffer(value.length() * (int)other_int);
            for (int i = 0; i < other_int; i++) {
                res.append(value);
            }
            return new Str(res.toString());
        }
        else if (other instanceof org.python.types.Bool) {
                boolean other_bool = ((org.python.types.Bool)other).value;
                if (other_bool) {
                        return new Str(value);
                } else {
                        return new Str("");
                }
        }
        throw new org.python.exceptions.TypeError("can't multiply sequence by non-int of type '" + other.typeName() + "'");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __mod__(org.python.Object other) {
        java.util.List<java.lang.Object> format_args = new java.util.ArrayList<java.lang.Object>();
        if (other instanceof org.python.types.List) {
            org.python.types.List oth = (org.python.types.List) other;
            for (org.python.Object obj: oth.value) {
                format_args.add(obj.toJava());
            }
        } else if (other instanceof org.python.types.Tuple) {
            org.python.types.Tuple oth = (org.python.types.Tuple) other;
            for (org.python.Object obj: oth.value) {
                format_args.add(obj.toJava());
            }
        } else if (other instanceof org.python.types.NoneType) {
            throw new org.python.exceptions.TypeError("not all arguments converted during string formatting");
        } else {
            format_args.add(other.toJava());
        }

        return new org.python.types.Str(java.lang.String.format(this.value, format_args.toArray()));
    }

    @org.python.Method(
        __doc__ = "",
        args = {"other"}
    )
    public org.python.Object __ipow__(org.python.Object other) {
        this.setValue(this.__pow__(other, null));
        return this;
    }

    @org.python.Method(
        __doc__=""
    )
    public org.python.Object __pos__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary +: 'str'");
    }

    @org.python.Method(
        __doc__=""
    )
    public org.python.Object __neg__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary -: 'str'");
    }

    @org.python.Method(
        __doc__=""
    )
    public org.python.Object __invert__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary ~: 'str'");
    }

    @org.python.Method(
        __doc__=""
    )
    public org.python.Object __bool__() {
        return new org.python.types.Bool(this.value.length() > 0);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __rmul__(org.python.Object other) {
        throw new org.python.exceptions.NotImplementedError("__rmul__() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __rmod__(org.python.Object other) {
        throw new org.python.exceptions.NotImplementedError("__rmod__() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = "",
        args = {"other"}
    )
    public org.python.Object __imul__(org.python.Object other) {
        this.setValue(this.__mul__(other));
        return this;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __imod__(org.python.Object other) {
        if (other instanceof org.python.types.NoneType) {
            throw new org.python.exceptions.TypeError("not all arguments converted during string formatting");
        }
        super.__imod__(other);
        return this;
    }


    @org.python.Method(
        __doc__ = "",
        args = {"other"}
    )
    public org.python.Object __iadd__(org.python.Object other) {
        try {
            this.setValue(this.__add__(other));
            return this;
        } catch (org.python.exceptions.TypeError e) {
            throw new org.python.exceptions.TypeError("Can't convert '" + other.typeName() + "' object to " + this.typeName() + " implicitly");
        }
    }
    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __round__(org.python.Object ndigits) {

         throw new org.python.exceptions.TypeError("type str doesn't define __round__ method");

    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object capitalize() {
        if (this.value.length() > 0) {
            String newval = this.value.substring(0, 1).toUpperCase() + this.value.substring(1).toLowerCase();
            return new Str(newval);
        }
        return this;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object casefold() {
        throw new org.python.exceptions.NotImplementedError("casefold() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object center() {
        throw new org.python.exceptions.NotImplementedError("center() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = "",
        args = {"item"},
        default_args = {"sub", "end"}
    )
    public org.python.Object count(org.python.Object sub, org.python.Object start, org.python.Object end) {
        String sub_str = ((Str) sub).toString();
        if (start == null) {
            start = new Int(0);
        }
        if (end == null) {
            end = new Int(this.value.length());
        }
        String original = this.__getitem__(new Slice(start, end)).toString();

        return new Int((original.length() - original.replace(sub_str, "").length()) / sub_str.length());
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object encode() {
        throw new org.python.exceptions.NotImplementedError("encode() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = "S.endswith(suffix[, start[, end]]) -> bool",
        args = {"item"}
    )
    public org.python.Object endswith(org.python.Object suffix) {
        return new org.python.types.Bool(this.value.endsWith(suffix.toString()));
    }

    @org.python.Method(
        __doc__ = "S.expandtabs([tabsize]) -> string",
        default_args= {"tabsize"}
    )
    public org.python.Object expandtabs(org.python.Object tabsize) {
        int tabsize_int = 8;
        if (tabsize != null) {
            tabsize_int = (int)((org.python.types.Int) tabsize).value;
        }
        if ( this.value == null ) return null;
        StringBuilder buf = new StringBuilder();
        int col = 0;
        for (int i = 0; i<this.value.length(); i++) {
            char c = this.value.charAt(i);
            switch ( c ) {
                case '\n' :
                    col = 0;
                    buf.append(c);
                    break;
                case '\t' :
                    buf.append(this.spaces(tabsize_int - col % tabsize_int));
                    col += tabsize_int - col % tabsize_int;
                    break;
                default :
                    col++;
                    buf.append(c);
                    break;
            }
        }
        return new Str(buf.toString());
    }
   private static String spaces(int n) {
        StringBuilder buf = new StringBuilder();
        for (int sp=1; sp<=n; sp++) buf.append(" ");
        return buf.toString();
    }

    @org.python.Method(
        __doc__ = "S.find(sub[, start[, end]]) -> int",
        args = {"item"},
        default_args = {"start", "end"}
    )
    public org.python.Object find(org.python.Object item, org.python.Object start, org.python.Object end) {
        if (start == null) {
            start = new Int(0);
        }
        if (end == null) {
            end = new Int(this.value.length());
        }
        int foundAt = this.__getitem__(new Slice(start, end)).toString().indexOf(item.toString());
        if (foundAt >= 0) {
            return new Int(foundAt + toPositiveIndex(((Int) start).value));
        }
        return new Int(foundAt);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object format() {
        throw new org.python.exceptions.NotImplementedError("format() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object format_map() {
        throw new org.python.exceptions.NotImplementedError("format_map() has not been implemented.");
    }

    private long toPositiveIndex(long index) {
        if (index < 0) {
            return this.value.length() + index;
        }
        return index;
    }

    @org.python.Method(
        __doc__ = "S.index(sub[, start[, end]]) -> int\n\nLike S.find() but raise ValueError when the substring is not found.",
        args = {"item"},
        default_args = {"start", "end"}
    )
    public org.python.Object index(org.python.Object item, org.python.Object start, org.python.Object end) {
        org.python.Object foundAt = this.find(item, start, end);
        if (((Int)foundAt).value < 0) {
            throw new org.python.exceptions.ValueError("substring not found");
        } else {
            return foundAt;
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isalnum() {
        throw new org.python.exceptions.NotImplementedError("isalnum() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isalpha() {
        throw new org.python.exceptions.NotImplementedError("isalpha() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isdecimal() {
        throw new org.python.exceptions.NotImplementedError("isdecimal() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isdigit() {
        throw new org.python.exceptions.NotImplementedError("isdigit() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isidentifier() {
        throw new org.python.exceptions.NotImplementedError("isidentifier() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object islower() {
        throw new org.python.exceptions.NotImplementedError("islower() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isnumeric() {
        throw new org.python.exceptions.NotImplementedError("isnumeric() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isprintable() {
        throw new org.python.exceptions.NotImplementedError("isprintable() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isspace() {
        throw new org.python.exceptions.NotImplementedError("isspace() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object istitle() {
        throw new org.python.exceptions.NotImplementedError("istitle() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object isupper() {
        throw new org.python.exceptions.NotImplementedError("isupper() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object join() {
        throw new org.python.exceptions.NotImplementedError("join() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object ljust() {
        throw new org.python.exceptions.NotImplementedError("ljust() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object lower() {
        return new Str(this.value.toLowerCase());
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object lstrip() {
        throw new org.python.exceptions.NotImplementedError("lstrip() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object maketrans() {
        throw new org.python.exceptions.NotImplementedError("maketrans() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object partition() {
        throw new org.python.exceptions.NotImplementedError("partition() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object replace() {
        throw new org.python.exceptions.NotImplementedError("replace() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object rfind() {
        throw new org.python.exceptions.NotImplementedError("rfind() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object rindex() {
        throw new org.python.exceptions.NotImplementedError("rindex() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object rjust() {
        throw new org.python.exceptions.NotImplementedError("rjust() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object rpartition() {
        throw new org.python.exceptions.NotImplementedError("rpartition() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object rsplit() {
        throw new org.python.exceptions.NotImplementedError("rsplit() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object rstrip() {
        throw new org.python.exceptions.NotImplementedError("rstrip() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object split() {
        throw new org.python.exceptions.NotImplementedError("split() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object splitlines() {
        throw new org.python.exceptions.NotImplementedError("splitlines() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object startswith() {
        throw new org.python.exceptions.NotImplementedError("startswith() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object strip() {
        throw new org.python.exceptions.NotImplementedError("strip() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object swapcase() {
        throw new org.python.exceptions.NotImplementedError("swapcase() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = "S.title() -> str\n\nReturn a titlecased version of S, i.e. words start with title case\ncharacters, all remaining cased characters have lower case."
    )
    public org.python.Object title() {
	if (this.value.isEmpty()){
	    return new Str(this.value);
	}
	String title = "";
	Character first = Character.toUpperCase(this.value.charAt(0));
	title += Character.toString(first);
	int c = 1;
	char prev;
	while(c < this.value.length()){
 	    prev = title.charAt(c - 1);
	    if(prev == ' '){
	        title += Character.toString(Character.toUpperCase(this.value.charAt(c)));
	    } else if (Character.isUpperCase(this.value.charAt(c))){
	        title += Character.toString(Character.toLowerCase(this.value.charAt(c)));
	    } else {
		title += Character.toString(this.value.charAt(c));
	    }
	    c ++;
	}
	return new Str(title);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object translate() {
        throw new org.python.exceptions.NotImplementedError("translate() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object upper() {
        return new org.python.types.Str(this.value.toUpperCase());
    }

}
