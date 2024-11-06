#### Useful commands

- `curl http://localhost:8085/v1/projects/bullla-one-d-apps-cn/topics`
- `curl http://localhost:8085/v1/projects/bullla-one-d-apps-cn/subscriptions`

```
curl -X POST \
-H "Content-Type: application/json" \
-d '{
  "messages": [
    {
      "data": "ewogICJpZCI6ICIxIiwKICAiZ2xvYmFsTGltaXQiOiAiMTAwMDAiLAogICJiaWxsaW5nRGF5IjogIjE1IiwKICAiaW52b2ljZUN1dG9mZkRheSI6ICIxNSIsCiAgIm1heFBheW1lbnRXaW5kb3ciOiAiMTAiLAogICJidXNpbmVzc0NsaWVudElkIjogIjEyMzQ1Igp9",
      "attributes": {
        "key": "value"
      }
    }
  ]
}' \
http://localhost:8085/v1/projects/bullla-one-d-apps-cn/topics/contract-updated:publish

```

- POSTMAN
- fazer em base64

```
JSON


{
  "messages": [
    {
      "data": "ewogICJpZCI6ICIxIiwKICAiZ2xvYmFsTGltaXQiOiAiMTAwMDAiLAogICJiaWxsaW5nRGF5IjogIjE1IiwKICAiaW52b2ljZUN1dG9mZkRheSI6ICIxNSIsCiAgIm1heFBheW1lbnRXaW5kb3ciOiAiMTAiLAogICJidXNpbmVzc0NsaWVudElkIjogIjEyMzQ1Igp9",
    }
  ]
}
```

- url: http://localhost:8085/v1/projects/bullla-one-d-apps-cn/topics/contract-updated:publish

- headers:
    - **Key**: `Content-Type`
    - **Value**: `application/json`