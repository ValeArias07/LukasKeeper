package services;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

public interface GeneralServicesInterface {
    public Response add(String category);
    public Response balance();
    public Response getTimeline();
    public Response getComparation(@QueryParam("type") String type);
    public Response getIndicators();
    public Response getList();
    public Response deleteItem(@QueryParam("id") int id);
}
