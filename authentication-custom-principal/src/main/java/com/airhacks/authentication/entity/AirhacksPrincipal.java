
package com.airhacks.authentication.entity;

import javax.security.enterprise.CallerPrincipal;

/**
 *
 * @author airhacks.com
 */
public class AirhacksPrincipal extends CallerPrincipal {

    private boolean alumni;

    public AirhacksPrincipal(String name) {
        super(name);
    }

    public boolean isAlumni() {
        return "duke".equalsIgnoreCase(super.getName());
    }

    @Override
    public String toString() {
        return "AirhacksPrincipal{" + "alumni=" + alumni + '}' + super.toString();
    }


}
