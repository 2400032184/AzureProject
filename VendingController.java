package com.klu.vending;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class VendingController {
    private final List<Map<String,Object>> requests = new ArrayList<>();
    private final AtomicInteger seq = new AtomicInteger(1001);

    public VendingController() {
        requests.add(make("1001","Travel Booking Portal","travel-team","Sandbox","eastus","CC1001","Pending"));
        requests.add(make("1002","AI Recommendation Engine","ai-team","Development","centralindia","CC1002","Approved"));
    }

    private Map<String,Object> make(String id,String app,String owner,String env,String region,String cc,String status){
        Map<String,Object> m=new LinkedHashMap<>();
        m.put("id",id);m.put("application",app);m.put("owner",owner);m.put("environment",env);
        m.put("region",region);m.put("costCenter",cc);m.put("status",status);
        m.put("tags", List.of("Environment="+env,"Owner="+owner,"CostCenter="+cc,"Project=SubscriptionVending"));
        m.put("policy","Required tags + allowed region");
        m.put("rbac","Application Team: Contributor");
        m.put("budget","Monthly budget + alert");
        return m;
    }

    @GetMapping("/requests")
    public List<Map<String,Object>> all(){ return requests; }

    @PostMapping("/requests")
    public Map<String,Object> create(@RequestBody Map<String,String> in){
        String id=String.valueOf(seq.incrementAndGet());
        Map<String,Object> m=make(id,in.getOrDefault("application","New App"),
          in.getOrDefault("owner","team"),in.getOrDefault("environment","Sandbox"),
          in.getOrDefault("region","eastus"),in.getOrDefault("costCenter","CC1000"),"Pending");
        requests.add(0,m); return m;
    }

    @PostMapping("/requests/{id}/approve")
    public Map<String,Object> approve(@PathVariable String id){
        return update(id,"Approved");
    }

    @PostMapping("/requests/{id}/vend")
    public Map<String,Object> vend(@PathVariable String id){
        Map<String,Object> m=update(id,"Vended");
        if(m != null){ m.put("subscriptionName","sub-"+m.get("environment")+"-"+m.get("application").toString().toLowerCase().replace(" ","-"));
            m.put("managementGroup","Landing-Zones/"+m.get("environment"));
            m.put("landingZone","Ready"); }
        return m;
    }

    private Map<String,Object> update(String id,String status){
        for(Map<String,Object> m:requests) if(m.get("id").equals(id)){m.put("status",status);return m;}
        return null;
    }

    @GetMapping("/dashboard")
    public Map<String,Object> dashboard(){
        long pending=requests.stream().filter(x->x.get("status").equals("Pending")).count();
        long approved=requests.stream().filter(x->x.get("status").equals("Approved")).count();
        long vended=requests.stream().filter(x->x.get("status").equals("Vended")).count();
        Map<String,Object> d=new LinkedHashMap<>();
        d.put("totalRequests",requests.size());d.put("pending",pending);d.put("approved",approved);d.put("vended",vended);
        d.put("policyCompliance","100% demo");d.put("governance","Policy + RBAC + Tags + Budget");
        return d;
    }
}
