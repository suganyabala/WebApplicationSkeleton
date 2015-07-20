/*
 * Copyright 2015 Livotov Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.livotov.labs.webskel.core.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import eu.livotov.labs.webskel.core.jpa.Log;

import javax.persistence.EntityManager;
import java.util.List;

public class LogsDao
{

    @Inject
    Provider<EntityManager> em;

    @Transactional
    public void addLogEntry(final String data)
    {
        Log log = new Log();
        log.setTimestamp(System.currentTimeMillis());
        log.setMessage(data);
        em.get().persist(log);
    }

    public List<Log> getLogs()
    {
        return em.get().createNamedQuery("getLogs").getResultList();
    }
}