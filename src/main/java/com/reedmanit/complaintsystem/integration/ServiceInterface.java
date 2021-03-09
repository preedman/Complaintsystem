/*
 * Copyright 2020 paul.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reedmanit.complaintsystem.integration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reedmanit.casedomain.cases.Case;
import com.reedmanit.casedomain.cases.Complaint;
import com.reedmanit.caseservice.CaseService;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author paul
 */
public class ServiceInterface {
    
    CaseService caseService = CaseService.getInstance();
    
    public ServiceInterface() {
        
    }
    public void save(Case c) throws Exception {
        
        String fail = "\"false\"";
        Gson gson = new Gson();
        String jsonCase = gson.toJson(c);
        
        String r = caseService.save(jsonCase);
        
        if (r.equals(fail)) {
            throw new Exception ("Did not save case");
        }
        
    }
    
    public List getListOfCases() throws Exception {
        
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<Complaint>>() {}.getType();
        Collection<Complaint> theCases = gson.fromJson(caseService.getAllCases(), collectionType);
        
        List<Complaint> newList = theCases.stream().collect(toList());
        
        return newList;
    }
    
}
